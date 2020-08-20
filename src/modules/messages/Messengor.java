package modules.messages;/*
 *@description
 *@author
 *@date
 */


import common.ParamCheckManager;
import common.WechatResponse;
import global.AppSettings;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.appmessages.AppMessageResponse;
import modules.messages.common.StatisticsMessageResponse;
import modules.messages.linkedcorpmessages.LinkedCorpMessageBase;
import modules.messages.linkedcorpmessages.LinkedCorpMessageResponse;
import modules.messages.sessionmessages.SessionMessageBase;
import util.HttpUtility;
import util.JsonUtility;

import java.util.HashMap;
import java.util.Map;

public class Messengor {

    /*
     *params:token:accesstoken,message推送的企业微信消息对象
     *author:zouwei
     *description:使用应用token，推送应用消息
     *createtime: 2020/08/11
     */
    public static final AppMessageResponse postMessage(String token, AppMessageBase message){
        AppMessageResponse response=new AppMessageResponse();
        response= ParamCheckManager.CheckNull("token",token, AppMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("AppMessageBase",message, AppMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String jsonMessage=JsonUtility.convertToJson(message);
        response=postAppMessage(token,jsonMessage);
        return response;
    }

    /*
     *params:token:企业微信群聊会话的accesstoken,message:需要发送的消息
     *author:zouwei
     *description:使用token推送
     *createtime: 
     */
    public static final WechatResponse postMessage(String token, SessionMessageBase message){
        WechatResponse response=new WechatResponse();
        response=ParamCheckManager.CheckNull("token",token,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("SessionMessageBase",message,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String jsonMessage=JsonUtility.convertToJson(message);
        response= postSessionMessage(token,jsonMessage);
        return response;
    }

    /*
     *params:token:accesstoken,linkedCorpMessage:
     *author:zouwei
     *description:推送互联企业消息
     *createtime: 2020/08/12
     */
    public static final LinkedCorpMessageResponse postMessage(String token, LinkedCorpMessageBase linkedCorpMessage){
        LinkedCorpMessageResponse response=new LinkedCorpMessageResponse();
        response=ParamCheckManager.CheckNull("token",token,LinkedCorpMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("LinkedCorpMessageBase",linkedCorpMessage,LinkedCorpMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String jsonMessage=JsonUtility.convertToJson(linkedCorpMessage);
        response= postLinkedCorpMessage(token,jsonMessage);
        return response;
    }

    /*
     *params:token:企业微信应用的accesstoken,jsonMessage:推送的微信消息的json格式字符串
     *author:zouwei
     *description:推送微信消息
     *createtime: 2020/08/11
     */
    public static final AppMessageResponse postAppMessage(String token, String jsonMessage){
        AppMessageResponse response=new AppMessageResponse();
        String url=String.format(AppSettings.Url_Post_Message,token);
        try {
            String jsonResult= HttpUtility.WeChatPost(url,jsonMessage);
            response= JsonUtility.convertFromJson(jsonResult, AppMessageResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params:token:accesstoken,群聊消息的json格式化字符串
     *author:zouwei
     *description:推送json格式化群聊消息
     *createtime: 2020/08/12
     */
    public static final WechatResponse postSessionMessage(String token,String jsonMessage){
        WechatResponse response=new WechatResponse();
        String url=String.format(AppSettings.Url_Post_SessionMessage,token);
        try {
            String result=HttpUtility.WeChatPost(url,jsonMessage);
            response=JsonUtility.convertFromJson(result,WechatResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params:token:accesstoken,jsonMessage:互联企业消息的json格式化字符串
     *author:zouwei
     *description:推送互联企业消息
     *createtime: 2020/08/12
     */
    public static final LinkedCorpMessageResponse postLinkedCorpMessage(String token,String jsonMessage){
        LinkedCorpMessageResponse response=new LinkedCorpMessageResponse();
        response=ParamCheckManager.CheckNull("token",token,LinkedCorpMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("jsonMessage",jsonMessage,LinkedCorpMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Post_LinkedCorpMessage,token);
        try {
            String result=HttpUtility.WeChatPost(url,jsonMessage);
            response=JsonUtility.convertFromJson(jsonMessage,LinkedCorpMessageResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params:token:accesstoken,timetype:查询哪天的数据 0.当天 1.昨天
     *author:zouwei
     *description:查询应用消息统计
     *createtime: 2020/08/12
     */
    public static final StatisticsMessageResponse getMessageStatistics(String token,int timetype){
        StatisticsMessageResponse response=new StatisticsMessageResponse();
        response=ParamCheckManager.CheckNull("token",token,StatisticsMessageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Post_MessageStatistics,token);
        Map<String,String> map=new HashMap<>();
        map.put("time_type",String.valueOf(timetype));
        String jsonRequest=JsonUtility.convertToJson(map);
        try {
            String result=HttpUtility.WeChatPost(url,jsonRequest);
            response=JsonUtility.convertFromJson(result,StatisticsMessageResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return  response;
        }
    }
}

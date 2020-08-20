package modules.groupsession;/*
 *@description
 *@author
 *@date
 */

import common.ParamCheckManager;
import common.WechatResponse;
import global.AppSettings;
import util.HttpUtility;
import util.JsonUtility;

public class GroupSession {

    public static final GroupSessionCreateResponse Create(String token,GroupSessionCreate groupSession){
        GroupSessionCreateResponse response=new GroupSessionCreateResponse();
        response=ParamCheckManager.CheckNull("tokne",token,GroupSessionCreateResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("groupSession",groupSession,GroupSessionCreateResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String jsonRequest= JsonUtility.convertToJson(groupSession);
        String url=String.format(AppSettings.Url_Session_Create,token);
        try {
            String result= HttpUtility.WeChatPost(url,jsonRequest);
            response=JsonUtility.convertFromJson(result,GroupSessionCreateResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    public static final WechatResponse Update(String token,GroupSessionUpdate groupSessionUpdate){
        WechatResponse response=new WechatResponse();
        response=ParamCheckManager.CheckNull("token",token,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("groupSessionUpdate",groupSessionUpdate,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String jsonRequest=JsonUtility.convertToJson(groupSessionUpdate);
        String url=String.format(AppSettings.Url_Session_Update,token);
        try {
            String result=HttpUtility.WeChatPost(url,jsonRequest);
            response=JsonUtility.convertFromJson(result,WechatResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    public static final GroupSessionGetResponse Get(String token,String chatid){
        GroupSessionGetResponse response=new GroupSessionGetResponse();
        response= ParamCheckManager.CheckNull("token",token,GroupSessionGetResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("chatid",chatid,GroupSessionGetResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Session_Get,token,chatid);
        try {
            String result=HttpUtility.WeChatGet(url);
            response=JsonUtility.convertFromJson(result,GroupSessionGetResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }
}

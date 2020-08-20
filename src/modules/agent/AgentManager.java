package modules.agent;/*
 *@description
 *@author
 *@date
 */

import common.ParamCheckManager;
import common.WechatResponse;
import global.AppSettings;
import util.HttpUtility;
import util.JsonUtility;

public class AgentManager {

    /*
     *params: token:accesstoken,agentid:应用标识
     *author:zouwei
     *description:根据agentid获取应用的详细信息
     *createtime: 2020/08/17
     */
    public static final AgentResponse agent(String token,int agentid){
        AgentResponse response=new AgentResponse();
        response= ParamCheckManager.CheckNull("tokne",token,AgentResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Agent_Get,token,agentid);
        try {
            String jsonResponse= HttpUtility.WeChatGet(url);
            response= JsonUtility.convertFromJson(jsonResponse,AgentResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params: token:accesstoken,agent:应用的详细信息
     *author:zouwei
     *description:创建新的应用
     *createtime: 2020/08/17
     */
    public static final WechatResponse createAgent(String token, Agent agent){
        WechatResponse response=new WechatResponse();
        response=ParamCheckManager.CheckNull("token",token,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("agentObject",agent,WechatResponse.class);
        if(response==null ||!response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Agent_Post,token);
        try {
            String jsonReuqest=JsonUtility.convertToJson(agent);
            String jsonResponse=HttpUtility.WeChatPost(url,jsonReuqest);
            response=JsonUtility.convertFromJson(jsonResponse,WechatResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params: token:accesstoken,agentid:应用id
     *author:zouwei
     *description:获取应用的菜单
     *createtime: 2020/08/18
     */
    public static final Menu menu(String token,int agentId){
        Menu menu=new Menu();
        if(token==null || token.trim()=="")
        {
            menu.setSuccess(false);
            menu.setException(new NullPointerException("token is null or empty"));
            return menu;
        }
        String url=String.format(AppSettings.Url_Menu_Get,token,agentId);
        try {
            String jsonResponse=HttpUtility.WeChatGet(url);
            menu=JsonUtility.convertFromJson(jsonResponse,Menu.class);
            menu.setSuccess(true);
            return menu;
        }
        catch (Exception e){
            menu.setSuccess(false);
            menu.setException(e);
            return menu;
        }
    }

    /*
     *params: token：accesstoken,agentId:应用id,menu:菜单对象
     *author:zouwei
     *description:创建菜单
     *createtime: 2020/08/18
     */
    public static final WechatResponse createMenu(String token,int agentId,Menu menu){
        WechatResponse response=new WechatResponse();
        response=ParamCheckManager.CheckNull("token",token,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("menu",menu,WechatResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Agent_Post,token,agentId);
        try {
            String jsonRequest=JsonUtility.convertToJson(menu);
            String jsonResponse=HttpUtility.WeChatPost(url,jsonRequest);
            response=JsonUtility.convertFromJson(jsonResponse,WechatResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    /*
     *params:token:accesstoken,agentid:应用id
     *author:zouwei
     *description:根据agentid删除菜单
     *createtime: 2020/08/18
     */
    public static final WechatResponse deleteMenu(String token,int agentId){
        WechatResponse response=new WechatResponse();
        response=ParamCheckManager.CheckNull("token",token,WechatResponse.class);
        if(response==null ||!response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Menu_Delete,token,agentId);
        try {
            String jsonResponse=HttpUtility.WeChatGet(url);
            response=JsonUtility.convertFromJson(jsonResponse,WechatResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }
}

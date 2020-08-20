package modules.accesstoken;/*
 *@description
 *@author zouwei
 *@date 2020/08/10
 */

import common.ParamCheckManager;
import global.AppSettings;
import util.HttpUtility;
import util.JsonUtility;

public class AccessToken {
    /*
     *params:corpid:企业微信id，secret:企业微信应用密钥
     *author:zouwei
     *description:根据企业id和应用密钥获取应用token
     *createtime: 2020/08/11
     */
    public static final AccessTokenResponse accessToken(String corpid,String secret){
        AccessTokenResponse response=new AccessTokenResponse();
        response= ParamCheckManager.CheckNull("corpid",corpid,AccessTokenResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("secret",secret,AccessTokenResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Get_AccessToken,corpid,secret);
        try {
            String jsonResponse= HttpUtility.WeChatGet(url);
            response= JsonUtility.convertFromJson(jsonResponse,AccessTokenResponse.class);
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
        }
        return response;
    }
}

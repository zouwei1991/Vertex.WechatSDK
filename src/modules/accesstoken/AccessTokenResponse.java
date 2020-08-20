package modules.accesstoken;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class AccessTokenResponse extends WechatResponse {

    @SerializedName(value = "access_token")
    private String accesstoken;
    public String getAccesstoken(){
        return  accesstoken;
    }
    public void setAccesstoken(String token){
        accesstoken=token;
    }

    @SerializedName(value = "expires_in")
    private int expire;
    public int getExpire(){
        return  expire;
    }
    public void setExpire(int expires){
        expire=expires;
    }

}

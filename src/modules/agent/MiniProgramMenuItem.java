package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class MiniProgramMenuItem extends MenuItem{

    @SerializedName(value = "pagepath")
    private String pagePath;

    @SerializedName(value = "appid")
    private String appId;

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

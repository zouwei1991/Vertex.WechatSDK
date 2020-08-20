package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class ViewMenuItem extends MenuItem {
    @SerializedName(value = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

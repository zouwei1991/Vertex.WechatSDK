package modules.media;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class ImageResponse extends WechatResponse {

    @SerializedName(value = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class ImageMessagePart {

    @SerializedName(value = "media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

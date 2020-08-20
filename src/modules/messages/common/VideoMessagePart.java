package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class VideoMessagePart {

    @SerializedName(value = "media_id")
    private String mediaId;

    @SerializedName(value = "title")
    private String title;

    @SerializedName(value = "description")
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

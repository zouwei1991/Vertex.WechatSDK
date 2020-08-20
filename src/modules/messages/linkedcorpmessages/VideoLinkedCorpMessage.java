package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.VideoMessagePart;

public class VideoLinkedCorpMessage extends LinkedCorpMessageBase {

    @SerializedName(value = "video")
    private VideoMessagePart video;

    public VideoMessagePart getVideo() {
        return video;
    }

    public void setVideo(VideoMessagePart video) {
        this.video = video;
    }
}

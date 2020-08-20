package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.VideoMessagePart;

public class VideoSessionMessage extends SessionMessageBase {

    @SerializedName(value = "video")
    private VideoMessagePart video;

    public VideoMessagePart getVideo() {
        return video;
    }

    public void setVideo(VideoMessagePart video) {
        this.video = video;
    }
}

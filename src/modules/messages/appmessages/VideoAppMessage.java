package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.VideoMessagePart;

public class VideoAppMessage extends AppMessageBase {

    @SerializedName(value = "video")
    private VideoMessagePart video;

    public VideoMessagePart getVideo() {
        return video;
    }

    public void setVideo(VideoMessagePart video) {
        this.video = video;
    }
}

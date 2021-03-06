package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.ImageMessagePart;

public class ImageLinkedCorpMessage extends LinkedCorpMessageBase {

    @SerializedName(value = "image")
    private ImageMessagePart image;

    public ImageMessagePart getImage() {
        return image;
    }

    public void setImage(ImageMessagePart image) {
        this.image = image;
    }
}

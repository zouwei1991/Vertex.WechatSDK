package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.ImageMessagePart;

public class ImageAppMessage extends AppMessageBase {

    @SerializedName(value = "image")
    private ImageMessagePart image;

    public ImageMessagePart getImage() {
        return image;
    }

    public void setImage(ImageMessagePart image) {
        this.image = image;
    }
}

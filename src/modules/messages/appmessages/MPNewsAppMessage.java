package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.MPNewsMessagePart;

public class MPNewsAppMessage extends AppMessageBase {
    public MPNewsMessagePart getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(MPNewsMessagePart newsMessage) {
        this.newsMessage = newsMessage;
    }

    @SerializedName(value = "mpnews")
    private MPNewsMessagePart newsMessage;
}

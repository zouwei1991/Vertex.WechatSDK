package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.TextMessagePart;

public class TextAppMessage extends AppMessageBase {

    @SerializedName(value = "text")
    private TextMessagePart text;

    public TextMessagePart getText() {
        return text;
    }

    public void setText(TextMessagePart text) {
        this.text = text;
    }
}

package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.MessageBase;
import modules.messages.common.TextMessagePart;

public class TextSessionMessage extends SessionMessageBase {

    @SerializedName(value = "text")
    private TextMessagePart text;

    public TextMessagePart getText() {
        return text;
    }

    public void setText(TextMessagePart text) {
        this.text = text;
    }
}

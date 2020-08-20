package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.TextMessagePart;

public class TextLinkedCorpMessage extends LinkedCorpMessageBase {

    @SerializedName(value = "text")
    private TextMessagePart text;

    public TextMessagePart getText() {
        return text;
    }

    public void setText(TextMessagePart text) {
        this.text = text;
    }
}

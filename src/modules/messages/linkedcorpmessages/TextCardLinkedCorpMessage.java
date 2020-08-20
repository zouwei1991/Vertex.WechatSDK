package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.TextCardPart;

public class TextCardLinkedCorpMessage extends LinkedCorpMessageBase{

    @SerializedName(value = "textcard")
    private TextCardPart textCard;

    public TextCardPart getTextCard() {
        return textCard;
    }

    public void setTextCard(TextCardPart textCard) {
        this.textCard = textCard;
    }
}

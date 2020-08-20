package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.TextCardPart;

public class TextCardAppMessage extends AppMessageBase {

    @SerializedName(value = "textcard")
    private TextCardPart textCard;

    public TextCardPart getTextCard() {
        return textCard;
    }

    public void setTextCard(TextCardPart textCard) {
        this.textCard = textCard;
    }
}

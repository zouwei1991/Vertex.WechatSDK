package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.MPNewsMessagePart;

public class MPNewsSessionMessage extends SessionMessageBase {

    @SerializedName(value = "mpnews")
    private MPNewsMessagePart mpnews;

    public MPNewsMessagePart getMpnews() {
        return mpnews;
    }

    public void setMpnews(MPNewsMessagePart mpnews) {
        this.mpnews = mpnews;
    }
}

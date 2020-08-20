package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.MessageBase;

public class SessionMessageBase extends MessageBase {

    @SerializedName(value = "chatid")
    private String chatid;

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }
}

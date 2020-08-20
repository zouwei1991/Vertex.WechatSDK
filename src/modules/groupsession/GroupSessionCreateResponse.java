package modules.groupsession;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class GroupSessionCreateResponse extends WechatResponse {

    @SerializedName(value = "chatid")
    private String chatId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}

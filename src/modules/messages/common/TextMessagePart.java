package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class TextMessagePart {

    @SerializedName(value = "content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

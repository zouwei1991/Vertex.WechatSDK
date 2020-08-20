package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.ResponseBase;
import common.WechatResponse;

public class AppMessageResponse extends WechatResponse {

    @SerializedName(value = "invaliduser")
    private String invalidUser;

    @SerializedName(value = "invalidparty")
    private String invalidParty;

    @SerializedName(value = "invalidtag")
    private String invalidTag;

    public String getInvalidUser() {
        return invalidUser;
    }

    public void setInvalidUser(String invalidUser) {
        this.invalidUser = invalidUser;
    }

    public String getInvalidParty() {
        return invalidParty;
    }

    public void setInvalidParty(String invalidParty) {
        this.invalidParty = invalidParty;
    }

    public String getInvalidTag() {
        return invalidTag;
    }

    public void setInvalidTag(String invalidTag) {
        this.invalidTag = invalidTag;
    }
}

package modules.groupsession;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class GroupSessionGetResponse extends WechatResponse {

    @SerializedName(value = "chat_info")
    private GroupSessionCreate groupSession;

    public GroupSessionCreate getGroupSession() {
        return groupSession;
    }

    public void setGroupSession(GroupSessionCreate groupSession) {
        this.groupSession = groupSession;
    }
}

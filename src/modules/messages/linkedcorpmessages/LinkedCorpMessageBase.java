package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.MessageBase;

public class LinkedCorpMessageBase extends MessageBase {

    @SerializedName(value = "touser")
    private String totalUser;

    @SerializedName(value = "toparty")
    private String totalParty;

    @SerializedName(value = "totag")
    private String totalTag;

    @SerializedName(value = "toall")
    private int toAll;

    @SerializedName(value = "agentid")
    private int agentId;

    public String getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(String totalUser) {
        this.totalUser = totalUser;
    }

    public String getTotalParty() {
        return totalParty;
    }

    public void setTotalParty(String totalParty) {
        this.totalParty = totalParty;
    }

    public String getTotalTag() {
        return totalTag;
    }

    public void setTotalTag(String totalTag) {
        this.totalTag = totalTag;
    }

    public int getToAll() {
        return toAll;
    }

    public void setToAll(int toAll) {
        this.toAll = toAll;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}

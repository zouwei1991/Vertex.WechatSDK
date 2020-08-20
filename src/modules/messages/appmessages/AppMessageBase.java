package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.MessageBase;

public abstract class AppMessageBase extends MessageBase {

    @SerializedName(value = "touser")
    private String totalUser;

    @SerializedName(value = "toparty")
    private String totalParty;

    @SerializedName(value = "totag")
    private String totalTag;

    @SerializedName(value = "agentid")
    private int agentid;

    @SerializedName(value = "enable_id_trans")
    private int enableIdTrans;

    @SerializedName(value = "enable_duplicate_check")
    private int enableDuplicateCheck;

    @SerializedName(value = "duplicate_check_interval")
    private int duplicateCheckInterval;

    public String getTotalUser(){
        return totalUser;
    }
    public void setTotalUser(String user){
        totalUser=user;
    }

    public String getTotalParty(){
        return totalParty;
    }
    public void setTotalParty(String party){
        totalParty=party;
    }

    public String getTotalTag(){
        return totalTag;
    }
    public void setTotalTag(String tag){
        totalTag=tag;
    }

    public int getAgentid(){
        return agentid;
    }
    public void setAgentid(int id){
        agentid=id;
    }



    public int getEnableIdTrans() {
        return enableIdTrans;
    }

    public void setEnableIdTrans(int enableIdTrans) {
        this.enableIdTrans = enableIdTrans;
    }

    public int getEnableDuplicateCheck() {
        return enableDuplicateCheck;
    }

    public void setEnableDuplicateCheck(int enableDuplicateCheck) {
        this.enableDuplicateCheck = enableDuplicateCheck;
    }

    public int getDuplicateCheckInterval() {
        return duplicateCheckInterval;
    }

    public void setDuplicateCheckInterval(int duplicateCheckInterval) {
        this.duplicateCheckInterval = duplicateCheckInterval;
    }
}

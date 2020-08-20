package modules.groupsession;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class GroupSessionUpdate {

    @SerializedName(value = "chatid")
    private String chatId;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "owner")
    private String owner;

    @SerializedName(value = "add_user_list")
    private String[] addUserList={};

    @SerializedName(value = "del_user_list")
    private String[] delUserList={};

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String[] getAddUserList() {
        return addUserList;
    }

    public void setAddUserList(String[] addUserList) {
        this.addUserList = addUserList;
    }

    public String[] getDelUserList() {
        return delUserList;
    }

    public void setDelUserList(String[] delUserList) {
        this.delUserList = delUserList;
    }
}

package modules.groupsession;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class GroupSessionCreate {

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "owner")
    private String owner;

    @SerializedName(value = "userlist")
    private String[] userList;

    @SerializedName(value = "chatid")
    private String chatid;

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

    public String[] getUserList() {
        return userList;
    }

    public void setUserList(String[] userList) {
        this.userList = userList;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }
}

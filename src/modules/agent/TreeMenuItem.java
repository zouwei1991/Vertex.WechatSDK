package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class TreeMenuItem extends MenuItem{

    @SerializedName(value = "key")
    private String key;

    @SerializedName(value = "sub_button")
    private MenuItem[] subMenuItems;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MenuItem[] getSubMenuItems() {
        return subMenuItems;
    }

    public void setSubMenuItems(MenuItem[] subMenuItems) {
        this.subMenuItems = subMenuItems;
    }
}

package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class MenuItemList{

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "sub_button")
    private MenuItem[] subMenuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItem[] getSubMenuItems() {
        return subMenuItems;
    }

    public void setSubMenuItems(MenuItem[] subMenuitems) {
        this.subMenuItems = subMenuitems;
    }
}

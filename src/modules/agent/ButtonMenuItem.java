package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class ButtonMenuItem extends MenuItem {
    @SerializedName(value = "key")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

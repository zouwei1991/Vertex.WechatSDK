package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class Menu {

    private boolean isSuccess;

    private Exception exception;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @SerializedName(value = "button")
    private MenuItemList[] menu;

    public MenuItemList[] getMenu() {
        return menu;
    }

    public void setMenu(MenuItemList[] menu) {
        this.menu = menu;
    }
}

package common;/*
 *@description
 *@author
 *@date
 */

import global.AppSettings;

public class WeChatException extends Exception {
    private int errorCode;

    private String errorMessage;

    public WeChatException(int code){
        errorCode=code;
        errorMessage=String.format("Wechat Server response an error,errorcode is %s,more details refer to:%s",
                code, AppSettings.Url_Get_Document);
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}

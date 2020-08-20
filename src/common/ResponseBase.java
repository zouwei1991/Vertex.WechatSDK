package common;

import com.google.gson.annotations.SerializedName;

public abstract class ResponseBase {

    //微信接口的返回状态码 0 成功 其他 失败
    @SerializedName(value = "errcode")
    private int errorCode;
    public  void setErrorCode(int errorcode){
        errorCode=errorcode;
    }
    public int getErrorCode(){
        return errorCode;
    }

    //错误消息，微信接口返回错误状态码时对应的错误说明
    @SerializedName(value = "errmsg")
    private String errorMessage;
    public void setErrorMessage(String error){
        errorMessage=error;
    }
    public String getErrorMessage(){
        return errorMessage;
    }

    /*
    *params: * @Param: null
    *author:zouwei
    *description:判断微信接口是否成功返回 true 成功，false 失败
    *createtime: 2020/08/10
    */
    public boolean IsSuccess(){
        return errorCode==0 && programState==0;
    }

    //请求微信接口时发生的异常，没有则为null
    private Exception exception;
    public Exception getException(){
        if(errorCode!=0){
            WeChatException weChatException=new WeChatException(errorCode);
            return weChatException;
        }
        return exception;
    }
    public void setException(Exception exc){
        exception=exc;
    }

    //程序状态 0 正常 1.程序异常 2.参数校验错误
    private int programState;
    public int getProgramState(){
        return programState;
    }
    public void setProgramState(int state){
        programState=state;
    }
}

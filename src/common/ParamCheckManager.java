package common;/*
 *@description
 *@author
 *@date
 */

public class ParamCheckManager {

    public static <T extends WechatResponse> T CheckNull(String paramName,String paramValue,Class<T> tClass){
        try {
            T t=tClass.newInstance();
            if(paramValue==null || paramValue==""){
                t.setProgramState(1);
                String message=String.format("param %s is null or empty",paramName);
                t.setException(new NullPointerException(message));
            }
            return t;
        }
        catch (Exception e){
            return null;
        }
    }

    public static <T extends WechatResponse> T CheckNull(String paramName,Object paramValue,Class<T> tClass){
        try {
            T t=tClass.newInstance();
            if(paramValue==null){
                t.setProgramState(1);
                t.setException(new NullPointerException(String.format("param %s is null",paramName)));
            }
            return t;
        }
        catch (Exception e){
            return null;
        }
    }
}

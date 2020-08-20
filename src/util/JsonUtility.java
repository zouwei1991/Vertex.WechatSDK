package util;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonUtility {
    public static final String convertToJson(Object obj){
        Gson json=new Gson();
        String result= json.toJson(obj);
        return result;
    }

    public static final <T> T convertFromJson(String jsonString,Class<T> tClass){
        Gson json=new Gson();
        T result=json.fromJson(jsonString,tClass);
        return result;
    }

    public static final <T> T convertFromJson(String jsonString, Type type){
        Gson json=new Gson();
        T result=json.fromJson(jsonString,type);
        return result;
    }
}

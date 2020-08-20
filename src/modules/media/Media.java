package modules.media;/*
 *@description
 *@author
 *@date
 */

import common.ParamCheckManager;
import global.AppSettings;
import util.HttpUtility;
import util.JsonUtility;

import javax.net.ssl.HttpsURLConnection;

public class Media {

    private static String[] fileTypes={"image","voice","video","file"};

    /*
     *params:token:token
     *author:zouwei
     *description:
     *createtime: 
     */
    public static final MediaResponse postMedia(String token,String type,String filepath){
        MediaResponse response=new MediaResponse();
        response= ParamCheckManager.CheckNull("token",token,MediaResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("filepath",filepath,MediaResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("type",type,MediaResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        if(!containsType(type)){
            response.setProgramState(1);
            response.setException(new Exception("the type is invalid"));
            return response;
        }
        String url=String.format(AppSettings.Url_Post_Media,token,type);
        try {
            String jsonResponse= HttpUtility.WeChatUpload(url,filepath);
            response= JsonUtility.convertFromJson(jsonResponse,MediaResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    public static final ImageResponse postImage(String token,String filepath){
        ImageResponse response=new ImageResponse();
        response=ParamCheckManager.CheckNull("token",token,ImageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("filepath",filepath,ImageResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Post_Image,token);
        try {
            String jsonResponse=HttpUtility.WeChatUpload(url,filepath);
            response=JsonUtility.convertFromJson(jsonResponse,ImageResponse.class);
            return response;
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    public static final DownloadResponse getMedia(String token,String mediaId){
        DownloadResponse response=new DownloadResponse();
        response=ParamCheckManager.CheckNull("token",token,DownloadResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        response=ParamCheckManager.CheckNull("mediaId",mediaId,DownloadResponse.class);
        if(response==null || !response.IsSuccess())
            return response;
        String url=String.format(AppSettings.Url_Get_Media,token,mediaId);
        try {
            String stringResponse=HttpUtility.WeChatDownload(url);
            if(stringResponse.contains("errCode")){
                response=JsonUtility.convertFromJson(stringResponse,DownloadResponse.class);
                return response;
            }
            else {
                response.setErrorCode(0);
                response.setFileBytes(stringResponse.getBytes());
                return response;
            }
        }
        catch (Exception e){
            response.setProgramState(1);
            response.setException(e);
            return response;
        }
    }

    private static boolean containsType(String type){
        if(type==null || type.trim()=="")
            return false;
        for (int i=0;i<fileTypes.length;i++){
            if(fileTypes[i]==type){
                return true;
            }
        }
        return false;
    }
}


/*
 *@description
 *@author
 *@date
 */
package util;
import com.sun.jndi.toolkit.url.Uri;
import org.omg.IOP.Encoding;
import sun.net.www.http.HttpClient;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class HttpUtility {

    /*
     *params: url:企业微信的接口url
     *author:zouwei
     *description:使用http get请求微信接口
     *createtime: 2020/08/10
     */
    public static final String WeChatGet(String url) throws Exception {
        String response="";
        URL u=new URL(url);
        HttpsURLConnection connection=(HttpsURLConnection) u.openConnection();
        setHttpsGetRequest(connection);
        response=getHttpsResponse(connection);
        return  response;
    }

    /*
     *params: * url:企业微信的接口url,data:json格式的字符串
     *author:zouwei
     *description:使用http post向微信接口提交数据
     *createtime:2020/08/10
     */
    public static final String WeChatPost(String url,String data) throws Exception{
        String response="";
        URL u=new URL(url);
        HttpsURLConnection connection=(HttpsURLConnection) u.openConnection();
        setHttpsPostRequest(connection,data);
        response= getHttpsResponse(connection);
        return response;
    }

    public static final String WeChatUpload(String url,String filepath) throws Exception{
        if(url==null || url.trim()=="")
            throw new NullPointerException("url is null or empty");
        if(filepath==null || filepath.trim()=="")
            throw new NullPointerException("filepath is null or empty");
        String response="";
        URL u=new URL(url);
        HttpsURLConnection connection=(HttpsURLConnection) u.openConnection();
        setHttpUploadRequest(connection,filepath);
        response=getHttpsResponse(connection);
        return response;
    }

    public static final String WeChatDownload(String url) throws Exception{
        if(url==null || url.trim()=="")
            throw new NullPointerException("url is null or empty");
        URL u=new URL(url);
        HttpsURLConnection connection=(HttpsURLConnection)u.openConnection();
        setHttpsDownloadRequest(connection);
        String response=getHttpsResponse(connection);
        return response;
    }

    private static void setHttpsDownloadRequest(HttpsURLConnection connection) throws Exception {
        if(connection==null)
            return;
        SSLContext context=SSLContext.getInstance("ssl");
        TrustManager[] tm={new CustomX509TrustManager()};
        context.init(null,tm,new SecureRandom());
        SSLSocketFactory ssf=context.getSocketFactory();
        connection.setSSLSocketFactory(ssf);
        connection.setRequestMethod("get");
        connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
        connection.setDoOutput(true);
        connection.setReadTimeout(60000);
        connection.connect();
    }

    private static final String boundary="WebkitFormBoundary";
    private static void setHttpUploadRequest(HttpsURLConnection connection, String filepath) throws Exception {
        if(connection==null)
            throw  new NullPointerException("connection is null");
        MediaType type=MediaTypeUtil.PharseFile(filepath);
        if(type==MediaType.unsupported)
            throw new Exception("file type is not supported");
        String contentType=getfileContentType(type);
        File file=new File(filepath);
        String filename= file.getName();
        int fileLength=(int)file.length();
        SSLContext context=SSLContext.getInstance("ssl");
        TrustManager[] tm={new CustomX509TrustManager()};
        context.init(null,tm,new SecureRandom());
        SSLSocketFactory ssf=context.getSocketFactory();
        connection.setSSLSocketFactory(ssf);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
        connection.setRequestProperty("Content-Type","multipart/form-data; boundary="+boundary);
        connection.setDoOutput(true);
        connection.setReadTimeout(60000);
        connection.connect();
        byte[] fileData=FileUtility.BinaryRead(filepath);
        writeFile(connection,filename,fileLength,contentType,fileData);
    }

    private static final String getfileContentType(MediaType type){
        String contentType="";
        switch (type){
            case amr:
                contentType="";
                break;
            case bmp:
                contentType="image/bmp";
                break;
            case jpg:
                contentType="image/jpg";
                break;
            case mp4:
                contentType="video/mp4";
                break;
            case png:
                contentType="image/png";
                break;
            case txt:
            case file:
            case unknown:
                contentType="application/octet-stream";
                break;
            case unsupported:
                contentType="";
                break;
        }
        return contentType;
    }

    private static void setHttpsPostRequest(HttpsURLConnection connection,String data) throws Exception{
        if(connection==null)
            throw new NullPointerException("connection is null");
        SSLContext context=SSLContext.getInstance("ssl");
        TrustManager[] tm={new CustomX509TrustManager()};
        context.init(null,tm,new SecureRandom());
        SSLSocketFactory ssf= context.getSocketFactory();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
        connection.setRequestProperty("Content-Type","application/json");
        connection.setDoOutput(true);
        connection.setSSLSocketFactory(ssf);
        connection.setReadTimeout(6000);
        connection.connect();
        OutputStream os= connection.getOutputStream();
        if(data==null || data.trim()=="")
            return;
        os.write(data.getBytes("utf-8"));
    }

    private static void setHttpsGetRequest(HttpsURLConnection connection) throws Exception{
        if(connection==null)
            throw new NullPointerException("connection is null");
        SSLContext context=SSLContext.getInstance("ssl");
        TrustManager[] tm={new CustomX509TrustManager()};
        context.init(null,tm,new SecureRandom());
        SSLSocketFactory ssf= context.getSocketFactory();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
        connection.setRequestProperty("Content-Type","application/json");
        connection.setDoOutput(true);
        connection.setSSLSocketFactory(ssf);
        connection.setReadTimeout(6000);
        connection.connect();
    }

    private static String getHttpsResponse(HttpsURLConnection connection) throws Exception{
        String response="";
        if(connection==null)
            return response;
        if(connection.getResponseCode()==200){
            InputStream stream=connection.getInputStream();
            InputStreamReader reader=new InputStreamReader(stream,"utf-8");
            BufferedReader br=new BufferedReader(reader);
            StringBuffer sb=new StringBuffer();
            while (true){
                String temp=br.readLine();
                if(temp==null){
                    break;
                }
                else {
                    sb.append(temp);
                    sb.append("\r\n");
                }
            }
            response=sb.toString();
            connection.disconnect();
            return  response;
        }
        else {
            connection.disconnect();
            throw new IOException();
        }
    }

    private static void writeFile (HttpsURLConnection connection,String filename,int fileLength,String contentType,byte[] data)throws Exception{
        if(connection==null)
            return;
        OutputStream os=connection.getOutputStream();
        StringBuilder sb=new StringBuilder();
        sb.append("--"+boundary+"\r\n");
        sb.append("Content-Disposition: form-data; name=\"media\";filename=\""+filename+"\";filelength="+fileLength+"\r\n");
        sb.append("Content-Type:"+contentType+"\r\n");
        sb.append("\r\n");
        os.write(sb.toString().getBytes());
        if(data!=null){
            os.write(data);
            os.write("\r\n".getBytes());
        }
        os.write(("--"+boundary+"--\r\n").getBytes());
        os.flush();
    }

    private static void writeImage(HttpsURLConnection connection,String filename,int fileLength,String contentType,byte[] data) throws Exception{
        if(connection==null)
            return;
        OutputStream os=connection.getOutputStream();
        StringBuilder sb=new StringBuilder();
        sb.append("--"+boundary+"\r\n");
        sb.append("Content-Disposition: form-data; name=\"media\";filename=\""+filename+"\"\r\n");
        sb.append("Content-Type:"+contentType+"\r\n");
        sb.append("Content-Length:"+fileLength+"\r\n");
        sb.append("\r\n");
        os.write(sb.toString().getBytes());
        if(data!=null){
            os.write(data);
            os.write("\r\n".getBytes());
        }
        os.write(("--"+boundary+"--\r\n").getBytes());
        os.flush();
    }
}

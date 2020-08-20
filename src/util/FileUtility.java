package util;/*
 *@description
 *@author
 *@date
 */

import com.sun.istack.internal.NotNull;

import java.io.*;

public class FileUtility {

    /*
     *params:filepath:文件路径
     *author:zouwei
     *description:使用utf-8编码读取文件流
     *createtime: 2020/08/19
     */
    public static final String  ReadFile(@NotNull String filepath) throws Exception{
        if(filepath==null || filepath.trim()=="")
            throw new NullPointerException("filepath is null or empty");
        File file=new File(filepath);
        FileInputStream fs=new FileInputStream(file);
        InputStreamReader sr=new InputStreamReader(fs,"utf-8");
        BufferedReader br=new BufferedReader(sr);
        StringBuffer sb=new StringBuffer();
        while (true){
            String temp=br.readLine();
            if(temp==null)
                break;
            sb.append(temp+"\r\n");
        }
        return sb.toString();
    }

    public static final byte[] BinaryRead(String filepath) throws Exception{
        if(filepath==null || filepath.trim()=="")
            throw new NullPointerException("filepath is null or empty");
        File file=new File(filepath);
        FileInputStream fs=new FileInputStream(file);
        DataInputStream ds=new DataInputStream(fs);
        byte[] result=new byte[ds.available()];
        ds.read(result);
        return result;
    }
}

package util;/*
 *@description
 *@author
 *@date
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public enum MediaType {
    jpg,
    png,
    bmp,
    mp4,
    amr,
    txt,
    file,
    unsupported,
    unknown
}

class MediaTypeUtil {

    private static final short[] jpg={0xff,0xd8};

    private static final short[] png={0x89,0x50};

    private static final short[] bmp={0x42,0x4d};

    private static final short[] mp4_001={0x00,0x00,0x00,0x1c,0x66,0x74,0x79,0x70};

    private static final short[] mp4_002={0x00,0x00,0x00,0x18,0x66,0x74,0x79,0x70};

    private static final short[] mp4_003={0x00,0x00,0x00,0x14,0x66,0x74,0x79,0x70};

    private static final Map<String,short[]> map=new HashMap<>();

    private static final String[] fileList={".jpg",".bmp",".png",".txt",".csv"};

    private static final String[] videoList={".mp4"};

    private static final String[] voiceList={".amr"};

    static {
        map.put("jpg",jpg);
        map.put("bmp",bmp);
        map.put("png",png);
        map.put("mp4_001",mp4_001);
        map.put("mp4_002",mp4_002);
        map.put("mp4_003",mp4_003);
    }


    public static final MediaType PharseFile(String filepath) throws Exception{
        if(filepath==null || filepath.trim()=="")
            throw new Exception("filepath is null or empty");
        short[] headerBytes=getFileHeader(filepath);
        MediaType mediaType=matchHeader(headerBytes);
        if(mediaType!=MediaType.unknown)
            return mediaType;
        if(checkIfTxt(filepath)){
            return MediaType.txt;
        }
        return MediaType.file;
    }

    private static final short[] getFileHeader(String filepath){
        if(filepath==null || filepath=="")
            return null;
        File file=new File(filepath);
        try {
            short[] headbytes=new short[8];
            FileInputStream fs=new FileInputStream(file);
            for(int i=0;i<8;i++){
                int b=fs.read();
                short by=(short) b;
                headbytes[i]=by;
            }
            fs.close();
            return headbytes;
        }
        catch (Exception e){
            return null;
        }
    }

    private static final MediaType matchHeader(short[] headerBytes){
        if(headerBytes==null)
            return MediaType.unsupported;
        String key="";
        for (Map.Entry<String,short[]> pair:map.entrySet()) {
            short[] value= pair.getValue();
            short[] conpareBytes=null;
            if(value.length>=headerBytes.length){
                conpareBytes=headerBytes;
            }
            else {
                conpareBytes=new short[value.length];
                for(int i=0;i< conpareBytes.length;i++){
                    conpareBytes[i]=headerBytes[i];
                }
            }
            if(isEqualArray(value,conpareBytes)){
                key=pair.getKey();
                break;
            }
        }
        MediaType type;
        switch (key){
            case "jpg":
                type=MediaType.jpg;
                break;
            case "bmp":
                type=MediaType.bmp;
                break;
            case "png":
                type=MediaType.png;
                break;
            case "mp4_001":
            case "mp4_002":
            case "mp4_003":
                type=MediaType.mp4;
                break;
            default:
                type=MediaType.unknown;
                break;
        }
        return type;
    }

    private static final boolean checkIfTxt(String filePath){
        if(filePath==null || filePath=="")
            return false;
        File file=new File(filePath);
        try {
            boolean istxt=true;
            FileInputStream fs=new FileInputStream(file);
            while (true){
                int b=fs.read();
                if(b==-1)
                    break;
                if(b==0)
                {
                    istxt=false;
                    break;
                }
            }
            return istxt;
        }
        catch (Exception e){
            return false;
        }
    }

    private static final boolean checkIfCsv(String filePath){
        if(filePath==null || filePath=="")
            return false;
        File file=new File(filePath);
        try {
            FileInputStream fs=new FileInputStream(file);
            short temp1=0;

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private static final boolean isEqualArray(short[] a1,short[] a2){
        if(a1==null && a2==null)
            return true;
        if(a1==null || a2==null)
            return false;
        if(a1.length!=a2.length)
            return false;
        boolean equal=true;
        for(int i=0;i<a1.length;i++){
            if(a1[i]==a2[i])
                continue;
            equal=false;
            break;
        }
        return equal;
    }
}



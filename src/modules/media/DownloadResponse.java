package modules.media;/*
 *@description
 *@author
 *@date
 */

import common.WechatResponse;

public class DownloadResponse extends WechatResponse {
    private byte[] fileBytes;

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }
}

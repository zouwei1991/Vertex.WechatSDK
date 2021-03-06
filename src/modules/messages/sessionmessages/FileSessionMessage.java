package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.FileMessagePart;

public class FileSessionMessage extends SessionMessageBase {

    @SerializedName(value = "file")
    private FileMessagePart file;

    public FileMessagePart getFile() {
        return file;
    }

    public void setFile(FileMessagePart file) {
        this.file = file;
    }
}

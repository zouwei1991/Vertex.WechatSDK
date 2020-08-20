package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.FileMessagePart;

public class FileAppMessage extends AppMessageBase {

    @SerializedName(value = "file")
    public FileMessagePart file;

    public FileMessagePart getFile() {
        return file;
    }

    public void setFile(FileMessagePart file) {
        this.file = file;
    }
}

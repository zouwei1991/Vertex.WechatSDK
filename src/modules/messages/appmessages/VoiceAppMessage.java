package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.VoiceMessagePart;

public class VoiceAppMessage extends AppMessageBase {

    @SerializedName(value = "voice")
    private VoiceMessagePart voice;

    public VoiceMessagePart getVoice() {
        return voice;
    }

    public void setVoice(VoiceMessagePart voice) {
        this.voice = voice;
    }
}

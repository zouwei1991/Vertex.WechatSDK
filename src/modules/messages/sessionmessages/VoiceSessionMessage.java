package modules.messages.sessionmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.VoiceMessagePart;

public class VoiceSessionMessage extends SessionMessageBase {

    @SerializedName(value = "voice")
    private VoiceMessagePart voice;

    public VoiceMessagePart getVoice() {
        return voice;
    }

    public void setVoice(VoiceMessagePart voice) {
        this.voice = voice;
    }
}

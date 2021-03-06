package modules.messages.linkedcorpmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.common.NewsMessagePart;

public class NewsLinkedCorpMessage extends LinkedCorpMessageBase{

    @SerializedName(value = "news")
    private NewsMessagePart news;

    public NewsMessagePart getNews() {
        return news;
    }

    public void setNews(NewsMessagePart news) {
        this.news = news;
    }
}

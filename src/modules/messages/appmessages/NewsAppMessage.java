package modules.messages.appmessages;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import modules.messages.appmessages.AppMessageBase;
import modules.messages.common.NewsMessagePart;

public class NewsAppMessage extends AppMessageBase {

    @SerializedName(value = "news")
    private NewsMessagePart news;

    public NewsMessagePart getNews() {
        return news;
    }

    public void setNews(NewsMessagePart news) {
        this.news = news;
    }
}

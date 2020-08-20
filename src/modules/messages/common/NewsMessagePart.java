package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsMessagePart {

    @SerializedName(value = "articles")
    private ArrayList<NewsArticle> Articles=new ArrayList<NewsArticle>();

    public ArrayList<NewsArticle> getArticles() {
        return Articles;
    }

    public void setArticles(ArrayList<NewsArticle> articles) {
        Articles = articles;
    }
}

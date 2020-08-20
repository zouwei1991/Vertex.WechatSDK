package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MPNewsMessagePart {

    public ArrayList<MPNewsArticle> getMPArticles() {
        return MPArticles;
    }

    public void setMPArticles(ArrayList<MPNewsArticle> MPArticles) {
        this.MPArticles = MPArticles;
    }

    @SerializedName(value = "articles")
    private ArrayList<MPNewsArticle> MPArticles=new ArrayList<>();

}

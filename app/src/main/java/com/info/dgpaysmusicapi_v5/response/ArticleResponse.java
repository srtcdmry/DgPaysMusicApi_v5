package com.info.dgpaysmusicapi_v5.response;

import com.google.gson.annotations.SerializedName;
import com.info.dgpaysmusicapi_v5.model.Article;

import java.util.List;

public class ArticleResponse {
    @SerializedName("data")
    private List<Article> data;

    public List<Article> getArticles() {
        return data;
    }

    public void setArticles(List<Article> articles) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BashboardNewResponse{" +
                "data=" + data +
                '}';
    }
}

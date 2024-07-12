package com.example.client;

import java.util.ArrayList;
import java.util.List;

public class CategoryArticles {
    private String category;
    private List<Article> articles = new ArrayList<>();

    public CategoryArticles(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    @Override
    public String toString() {
        return "CategoryArticles{" + "category='" + category + '\'' + ", articles=" + articles + '}';
    }
}

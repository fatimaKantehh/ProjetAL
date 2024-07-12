package com.example.client;

public class Article {
    private String title;
    private String content;
    private String category;

    // Constructeurs, getters et setters
    public Article() {
    }

    public Article(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", category='" + category + '\''
                + '}';
    }
}

package com.example.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {
    private String title;
    private String category;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

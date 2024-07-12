package com.example.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();

    public ArticleRepository() {
        // Ajouter des articles par défaut
        Article article1 = new Article();
        article1.setTitle("Premier Article");
        article1.setCategory("Tech");
        articles.add(article1);

        Article article2 = new Article();
        article2.setTitle("Deuxième Article");
        article2.setCategory("Science");
        articles.add(article2);

        Article article3 = new Article();
        article3.setTitle("Troisième Article");
        article3.setCategory("Tech");
        articles.add(article3);
    }

    public List<Article> findAll() {
        return articles;
    }

    public List<Article> findByCategory(String category) {
        return articles.stream()
                .filter(article -> category.equals(article.getCategory()))
                .collect(Collectors.toList());
    }

    public void addArticle(Article article) {
        articles.add(article);
    }
}

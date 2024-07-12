package com.example.client;

import java.util.ArrayList;
import java.util.List;

public class RestClient {
    public List<Article> getArticles() {
        // Simuler un appel REST pour obtenir des articles
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Titre 1", "Contenu de l'article 1", "Categorie 1"));
        articles.add(new Article("Titre 2", "Contenu de l'article 2", "Categorie 2"));
        return articles;
    }

    public List<Article> getArticlesByCategory(String category) {
        // Simuler un appel REST pour obtenir des articles par catégorie
        List<Article> articles = new ArrayList<>();
        if ("Categorie 1".equals(category)) {
            articles.add(new Article("Titre 1", "Contenu de l'article 1", "Categorie 1"));
        } else if ("Categorie 2".equals(category)) {
            articles.add(new Article("Titre 2", "Contenu de l'article 2", "Categorie 2"));
        }
        return articles;
    }

    public List<CategoryArticles> getArticlesGroupedByCategory() {
        // Simuler un appel REST pour obtenir des articles groupés par catégorie
        List<CategoryArticles> groupedArticles = new ArrayList<>();
        CategoryArticles cat1 = new CategoryArticles("Categorie 1");
        cat1.addArticle(new Article("Titre 1", "Contenu de l'article 1", "Categorie 1"));
        CategoryArticles cat2 = new CategoryArticles("Categorie 2");
        cat2.addArticle(new Article("Titre 2", "Contenu de l'article 2", "Categorie 2"));
        groupedArticles.add(cat1);
        groupedArticles.add(cat2);
        return groupedArticles;
    }
}

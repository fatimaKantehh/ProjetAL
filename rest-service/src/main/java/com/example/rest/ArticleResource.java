package com.example.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/articles")
public class ArticleResource {

    private ArticleRepository repository = new ArticleRepository();

    @PostConstruct
    public void init() {
        Article article1 = new Article();
        article1.setTitle("Introduction à REST");
        article1.setCategory("Tech");

        Article article2 = new Article();
        article2.setTitle("REST vs SOAP");
        article2.setCategory("Tech");

        Article article3 = new Article();
        article3.setTitle("Dernières nouvelles de la santé");
        article3.setCategory("Santé");

        repository.addArticle(article1);
        repository.addArticle(article2);
        repository.addArticle(article3);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    @GET
    @Path("/category/{category}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Article> getArticlesByCategory(@PathParam("category") String category) {
        return repository.findByCategory(category);
    }
}

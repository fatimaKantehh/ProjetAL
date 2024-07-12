package com.example.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {
    private static final String BASE_URL = "http://localhost:8081/rest-service";

    public void getArticles() {
        try {
            URL url = new URL(BASE_URL + "/articles");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                ObjectMapper mapper = new ObjectMapper();
                List<Article> articles = mapper.readValue(inline.toString(), new TypeReference<List<Article>>() {
                });
                articles.forEach(article -> System.out.println(article.getTitle()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getArticlesByCategory(String category) {
        try {
            URL url = new URL(BASE_URL + "/articles/category/" + category);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                ObjectMapper mapper = new ObjectMapper();
                List<Article> articles = mapper.readValue(inline.toString(), new TypeReference<List<Article>>() {
                });
                articles.forEach(article -> System.out.println(article.getTitle()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getArticlesGroupedByCategory() {
        try {
            URL url = new URL(BASE_URL + "/articles/grouped");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                ObjectMapper mapper = new ObjectMapper();
                List<Article> articles = mapper.readValue(inline.toString(), new TypeReference<List<Article>>() {
                });
                articles.forEach(article -> System.out.println(article.getTitle()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

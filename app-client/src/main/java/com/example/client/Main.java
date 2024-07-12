package com.example.client;

public class Main {
    public static void main(String[] args) {
        // REST client example
        RestClient restClient = new RestClient();
        restClient.getArticles();
        restClient.getArticlesByCategory("technology");
        restClient.getArticlesGroupedByCategory();

        // SOAP client example
        SoapClient soapClient = new SoapClient();
        soapClient.authenticateUser("admin", "password");
        soapClient.listUsers();

        // Example of adding, updating, and deleting a user
        User user = new User();
        user.setUsername("newuser");
        user.setPassword("password");
        soapClient.addUser(user);

        user.setPassword("newpassword");
        soapClient.updateUser(user);

        soapClient.deleteUser(user.getUsername());
    }
}

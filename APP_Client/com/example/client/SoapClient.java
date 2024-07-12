package com.example.client;

import java.util.List;

public class SoapClient {
    private UserService userService;

    public SoapClient(UserService userService) {
        this.userService = userService;
    }

    public String authenticateUser(String username, String password) {
        // Simuler un appel SOAP pour authentifier un utilisateur et générer un jeton
        User user = userService.authenticate(username, password);
        if (user != null && "admin".equals(user.getRole())) {
            return userService.generateToken(username);
        }
        return null;
    }

    public boolean verifyToken(String username, String token) {
        // Simuler un appel SOAP pour vérifier le jeton
        return userService.verifyToken(username, token);
    }

    public List<User> listUsers() {
        // Simuler un appel SOAP pour lister les utilisateurs
        return userService.listUsers();
    }

    public void addUser(User user, String token) {
        // Simuler un appel SOAP pour ajouter un utilisateur
        if (userService.verifyToken(user.getUsername(), token)) {
            userService.addUser(user);
        }
    }

    public void updateUser(User user, String token) {
        // Simuler un appel SOAP pour mettre à jour un utilisateur
        if (userService.verifyToken(user.getUsername(), token)) {
            userService.updateUser(user);
        }
    }

    public void deleteUser(String username, String token) {
        // Simuler un appel SOAP pour supprimer un utilisateur
        if (userService.verifyToken(username, token)) {
            userService.deleteUser(username);
        }
    }
}

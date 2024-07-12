package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.UserService")
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> listUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println("Utilisateur ajouté avec succès: " + user.getUsername());
    }

    @Override
    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("Utilisateur supprimé avec succès: " + username);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                System.out.println("Utilisateur mis à jour avec succès: " + user.getUsername());
                return;
            }
        }
        System.out.println("Utilisateur non trouvé: " + user.getUsername());
    }

    @Override
    public TokenResponse authenticate(String login, String password) {
        for (User user : users) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                String token = TokenService.generateToken(login);
                return new TokenResponse(token);
            }
        }
        return new TokenResponse(null);
    }

    @Override
    public String generateToken(String username) {
        return TokenService.generateToken(username);
    }
}

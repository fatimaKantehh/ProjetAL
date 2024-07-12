package com.example.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();
    private Map<String, String> tokens = new HashMap<>();

    // Utilisateur administrateur par défaut
    public UserServiceImpl() {
        users.add(new User("admin", "password", "admin"));
    }

    @Override
    public User authenticate(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokens.put(username, token);
        return token;
    }

    @Override
    public boolean verifyToken(String username, String token) {
        return tokens.containsKey(username) && tokens.get(username).equals(token);
    }

    @Override
    public List<User> listUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                return;
            }
        }
    }

    @Override
    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        tokens.remove(username);
    }
}

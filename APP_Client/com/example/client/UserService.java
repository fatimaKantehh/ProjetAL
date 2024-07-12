package com.example.client;

import java.util.List;

public interface UserService {
    User authenticate(String username, String password);

    String generateToken(String username);

    boolean verifyToken(String username, String token);

    List<User> listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}

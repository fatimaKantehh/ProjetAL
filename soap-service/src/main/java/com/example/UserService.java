package com.example;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface UserService {
    List<User> listUsers();

    void addUser(User user);

    void deleteUser(String username);

    void updateUser(User user);

    TokenResponse authenticate(String login, String password);

    String generateToken(String username);
}

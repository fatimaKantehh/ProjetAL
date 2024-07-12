package com.example.client;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface UserService {
    boolean authenticate(String username, String password);

    List<User> listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String username);
}

package com.example.client;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient {
    private static final String WSDL_URL = "http://localhost:8080/soap-service?wsdl";
    private static final String NAMESPACE_URI = "http://example.com/";
    private static final String SERVICE_NAME = "UserServiceImplService";

    public void authenticateUser(String username, String password) {
        try {
            URL url = new URL(WSDL_URL);
            QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
            Service service = Service.create(url, qname);

            UserService userService = service.getPort(UserService.class);
            boolean isAuthenticated = userService.authenticate(username, password);
            System.out.println("Authentication status: " + isAuthenticated);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listUsers() {
        try {
            URL url = new URL(WSDL_URL);
            QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
            Service service = Service.create(url, qname);

            UserService userService = service.getPort(UserService.class);
            List<User> users = userService.listUsers();
            users.forEach(user -> System.out.println(user.getUsername()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            URL url = new URL(WSDL_URL);
            QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
            Service service = Service.create(url, qname);

            UserService userService = service.getPort(UserService.class);
            userService.addUser(user);
            System.out.println("User added: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            URL url = new URL(WSDL_URL);
            QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
            Service service = Service.create(url, qname);

            UserService userService = service.getPort(UserService.class);
            userService.updateUser(user);
            System.out.println("User updated: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        try {
            URL url = new URL(WSDL_URL);
            QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
            Service service = Service.create(url, qname);

            UserService userService = service.getPort(UserService.class);
            userService.deleteUser(username);
            System.out.println("User deleted: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

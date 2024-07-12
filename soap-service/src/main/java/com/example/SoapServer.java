package com.example;

import javax.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        Endpoint endpoint = Endpoint.create(userServiceImpl);

        endpoint.publish("http://localhost:8080/UserService");
        System.out.println("Service is published!");
    }
}

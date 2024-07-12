package com.example.rest;

import java.net.URI;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {
    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig().packages("com.example.rest");
        JettyHttpContainerFactory.createServer(URI.create("http://localhost:8081/"), config);
    }
}

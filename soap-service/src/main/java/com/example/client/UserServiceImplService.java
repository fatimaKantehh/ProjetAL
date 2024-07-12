package com.example.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.example.UserService;

public class UserServiceImplService extends Service {
    private final static URL USERSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static QName USERSERVICEIMPLSERVICE_QNAME = new QName("http://example.com/",
            "UserServiceImplService");

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/UserService?wsdl");
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(UserServiceImplService.class.getName())
                    .log(java.util.logging.Level.INFO,
                            "Can not initialize the default wsdl from {0}", "http://localhost:8080/UserService?wsdl");
        }
        USERSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public UserServiceImplService() {
        super(USERSERVICEIMPLSERVICE_WSDL_LOCATION, USERSERVICEIMPLSERVICE_QNAME);
    }

    public UserService getUserServiceImplPort() {
        return super.getPort(new QName("http://example.com/", "UserServiceImplPort"), UserService.class);
    }
}

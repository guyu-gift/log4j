package com.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Log4jApplication {

    private static final Logger logger = LogManager.getLogger(Log4jApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4jApplication.class, args);
    }

    @RequestMapping({"/hello"})
    public String hello(String payload) {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        logger.error("{}", payload);
        logger.info("{}", payload);
        logger.info(payload);
        logger.error(payload);
        return "ok";
    }
}

package com.example.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IdeaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IdeaApplication.class, args);
    }

}

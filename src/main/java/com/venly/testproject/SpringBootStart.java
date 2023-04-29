package com.venly.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.venly.testproject")
public class SpringBootStart extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }
}

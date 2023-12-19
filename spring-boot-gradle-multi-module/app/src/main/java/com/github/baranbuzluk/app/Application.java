package com.github.baranbuzluk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.baranbuzluk")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

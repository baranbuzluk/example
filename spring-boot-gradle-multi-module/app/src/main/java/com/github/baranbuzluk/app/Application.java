package com.github.baranbuzluk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.github.baranbuzluk")
@EntityScan(basePackages = "com.github.baranbuzluk")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

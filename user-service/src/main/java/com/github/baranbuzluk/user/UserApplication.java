package com.github.baranbuzluk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = UserApplication.BASE_PACKAGE)
@EntityScan(basePackages = UserApplication.BASE_PACKAGE)
@SpringBootApplication(scanBasePackages = UserApplication.BASE_PACKAGE)
public class UserApplication {
	static final String BASE_PACKAGE = "com.github.baranbuzluk.user";

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}

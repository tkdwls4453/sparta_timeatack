package com.sparta.timeatack06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sparta06Application {

    public static void main(String[] args) {
        SpringApplication.run(Sparta06Application.class, args);
    }

}

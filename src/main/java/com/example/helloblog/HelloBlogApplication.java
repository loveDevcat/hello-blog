package com.example.helloblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class HelloBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBlogApplication.class, args);
    }

}

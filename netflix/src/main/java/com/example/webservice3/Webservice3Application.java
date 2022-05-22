package com.example.webservice3;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Webservice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Webservice3Application.class, args);
    }

}

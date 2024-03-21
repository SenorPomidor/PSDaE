package ru.sbt.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnotherClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnotherClientApplication.class, args);
    }
}

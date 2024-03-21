package ru.sbt.lessons.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final RestTemplate restTemplate;

    public String callHello() {
        String url = "http://another-client-service:8081/hello";
        return restTemplate.getForObject(url, String.class);
    }
}

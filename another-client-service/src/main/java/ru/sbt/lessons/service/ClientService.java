package ru.sbt.lessons.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public String hello() {
        return "Hello World form another client!";
    }
}

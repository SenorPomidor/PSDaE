package ru.sbt.lessons.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.lessons.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/hello")
    public String callHello() {
        return clientService.callHello();
    }
}

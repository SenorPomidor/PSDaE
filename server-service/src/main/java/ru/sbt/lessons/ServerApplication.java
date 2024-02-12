package ru.sbt.lessons;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sbt.lessons.service.RandomNumberServiceImpl;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        Server server = ServerBuilder
                .forPort(8081)
                .addService(new RandomNumberServiceImpl()).build();

        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            log.warn("Ошибка на сервере: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}

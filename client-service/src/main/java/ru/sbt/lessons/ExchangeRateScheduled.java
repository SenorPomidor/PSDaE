package ru.sbt.lessons;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ExchangeRateScheduled {

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        RandomNumberGeneratorGrpc.RandomNumberGeneratorBlockingStub stub
                = RandomNumberGeneratorGrpc.newBlockingStub(channel);

        ExchangeRate.RandomNumberRequest request = ExchangeRate.RandomNumberRequest.newBuilder().build();

        try {
            ExchangeRate.RandomNumberResponse response = stub.generate(request);
            log.info("Курс USD/RUB - {}", response.getNumber());
        } catch (StatusRuntimeException e) {
            log.error("При попытке получить курс USD/RUB произошла ошибка - {}", e.getMessage());
        } finally {
            channel.shutdown();
        }

    }
}

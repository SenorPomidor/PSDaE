package ru.sbt.lessons.service;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import ru.sbt.lessons.ExchangeRate.RandomNumberResponse;
import ru.sbt.lessons.ExchangeRate.RandomNumberRequest;
import ru.sbt.lessons.RandomNumberGeneratorGrpc.RandomNumberGeneratorImplBase;

import java.util.Random;

@Service
public class RandomNumberServiceImpl extends RandomNumberGeneratorImplBase {

    private final Random random = new Random();

    @Override
    public void generate(RandomNumberRequest request, StreamObserver<RandomNumberResponse> responseObserver) {
        RandomNumberResponse response = RandomNumberResponse.newBuilder()
                .setNumber(random.nextInt(100))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

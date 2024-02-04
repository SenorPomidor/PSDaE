package ru.sbt.lessons.service;

import org.springframework.stereotype.Service;
import ru.sbt.lessons.dto.ExchangeRateDto;
import ru.sbt.lessons.response.Response;

import java.util.Random;

import static ru.sbt.lessons.response.ResponseBuilder.ok;

@Service
public class ExchangeRateService {

    private final Random random = new Random();

    public Response<ExchangeRateDto> getDollarToRubleExchangeRate() {
        return ok(new ExchangeRateDto(String.valueOf(random.nextInt(100))));
    }
}

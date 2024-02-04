package ru.sbt.lessons.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.lessons.dto.ExchangeRateDto;
import ru.sbt.lessons.response.Response;
import ru.sbt.lessons.service.ExchangeRateService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exchange")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/rate/usdrub")
    public Response<ExchangeRateDto> getRandomNumber() {
        return exchangeRateService.getDollarToRubleExchangeRate();
    }
}

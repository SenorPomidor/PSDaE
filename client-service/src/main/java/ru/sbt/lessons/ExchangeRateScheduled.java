package ru.sbt.lessons;

import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.sbt.lessons.dto.ExchangeRateDto;
import ru.sbt.lessons.feign.ExchangeClient;
import ru.sbt.lessons.response.Response;

import java.net.ConnectException;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ExchangeRateScheduled {

    private final ExchangeClient exchangeClient;

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {
        try {
            Response<ExchangeRateDto> exchangeResponse = exchangeClient.getDollarToRubleExchangeRate();

            if (exchangeResponse.isFail()) {
                log.warn("При попытке получить курс USD/RUB произошла ошибка - {}", exchangeResponse.getMessage());
                return;
            }

            log.info("Курс USD/RUB - {}", exchangeResponse.getData().getRate());
        } catch (RetryableException e) {
            log.warn("ExchangeRate сервис не доступен - {}", e.getMessage());
        }
    }
}

package ru.sbt.lessons.feign;

import feign.RequestLine;
import ru.sbt.lessons.dto.ExchangeRateDto;
import ru.sbt.lessons.response.Response;

public interface ExchangeClient {

    @RequestLine("GET /exchange/rate/usdrub")
    Response<ExchangeRateDto> getDollarToRubleExchangeRate();
}

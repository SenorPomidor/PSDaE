package ru.sbt.lessons.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.lessons.feign.ExchangeClient;

@Configuration
public class ClientConfiguration {

    @Value("${urls.serviceOne}")
    private String serviceOne;

    @Value("${feign.logger.level:BASIC}")
    private String feignLoggerLevel;

    @Bean
    public ExchangeClient serviceClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(1_000_000, 1_000_000))
                .logger(new Slf4jLogger(ExchangeClient.class))
                .logLevel(Logger.Level.valueOf(feignLoggerLevel))
                .retryer(Retryer.NEVER_RETRY)
                .target(ExchangeClient.class, serviceOne);

    }
}

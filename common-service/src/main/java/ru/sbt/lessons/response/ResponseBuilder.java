package ru.sbt.lessons.response;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@UtilityClass
public class ResponseBuilder implements Serializable {

    public <R> Response<R> ok() {
        return ok(null, null);
    }

    public <R> Response<R> ok(R data) {
        return ok(data, null);
    }

    public <R> Response<R> ok(String message) {
        return ok(null, message);
    }

    public <R> Response<R> ok(R data, String message) {
        return build(Response.ResponseStatus.SUCCESS, data, message);
    }

    public <R> Response<R> fail() {
        return fail(null, null);
    }

    public <R> Response<R> fail(R data) {
        return fail(data, null);
    }

    public <R> Response<R> fail(String message) {
        return fail(null, message);
    }

    public <R> Response<R> fail(R data, String message) {
        return build(Response.ResponseStatus.FAIL, data, message);
    }

    private <R> Response<R> build(Response.ResponseStatus status, R data, String message) {
        return Response.<R>builder()
                .status(status)
                .data(data)
                .message(message)
                .build();
    }
}


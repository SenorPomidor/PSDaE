package ru.sbt.lessons.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    @NonNull
    private ResponseStatus status;

    private T data;

    private String message;

    public boolean isSuccess() {
        return status == ResponseStatus.SUCCESS;
    }

    public boolean isFail() {
        return status == ResponseStatus.FAIL;
    }

    public enum ResponseStatus {
        SUCCESS, FAIL
    }

}

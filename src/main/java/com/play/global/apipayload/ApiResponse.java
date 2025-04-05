package com.play.global.apipayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonPropertyOrder({"isSuccess", "message", "result", "errorCode"})
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse <T>{
      private final boolean isSuccess;
    private final String message;
    private final T result;
    private final String errorCode;

    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, "", result, null);
    }

    public static <T> ApiResponse<T> onFailure(String message, String errorCode) {
        return new ApiResponse<>(false, message, null, errorCode);
    }


}
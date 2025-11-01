package dev.duc.tlmse.api.v1.controller.common;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public record ApiResponse<T>(
        String code,
        String message, T data)
        implements Serializable {

    public static <T> ApiResponse<T> success(String msg, T data) {
        return new ApiResponse<>(HttpStatus.OK.toString(), msg, data);
    }
}

package com.example.demo.common;


import lombok.Builder;

/**
 * Results
 *
 * @blame Android Team
 */
public class Results {
    public static Result ok() {
        return Result.builder()
                .success(true)
                .build();
    }

    public static Result ok(Object data) {
        return Result.builder()
                .success(true)
                .data(data)
                .build();
    }


    @Builder
    private static class Result<T> {
        private Boolean success;
        private String message;
        private String detail;
        private T data;
    }
}

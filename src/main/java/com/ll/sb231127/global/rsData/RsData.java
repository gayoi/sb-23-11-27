package com.ll.sb231127.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor(access = PROTECTED)
public class RsData<T>{
    private final String resultCode;
    private final String msg;
    private final T data;
    private final int statusCode;

    public static <T> RsData<T> of(String resultCode, String msg,T data){
        int statusCode = Integer.parseInt(resultCode);

        return new RsData<>(resultCode, msg, data,statusCode);
    }
    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 400; // 데이터가 200을 시작하고 400 이하일때 성공이다라고
    }
    public boolean isFail() {
        return !isSuccess();
    }
}


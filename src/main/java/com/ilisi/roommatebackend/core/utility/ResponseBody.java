package com.ilisi.roommatebackend.core.exception.utility;


import lombok.Getter;
import lombok.Setter;

public class ResponseBody<T> {
    @Getter
    @Setter
    private T data = null;

    @Getter
    @Setter
    private String message = null;

    public ResponseBody() {
    }

    public ResponseBody(T data) {
        this.data = data;
    }


    public ResponseBody(T data, String message) {
        this.data = data;
        this.message = message;
    }
}

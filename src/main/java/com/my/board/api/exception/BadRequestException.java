package com.my.board.api.exception;

// BRE 잘못된요청만 받아서 메세지를 준다.
// SUPER ( RTE ) exception을 터뜨려줌.
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

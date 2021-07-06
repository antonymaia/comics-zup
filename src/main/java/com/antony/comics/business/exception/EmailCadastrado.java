package com.antony.comics.business.exception;

public class EmailCadastrado extends RuntimeException {

    public EmailCadastrado(String msg){
        super(msg);
    }
    public EmailCadastrado(String msg, Throwable cause) {
        super(msg,cause);
    }
}

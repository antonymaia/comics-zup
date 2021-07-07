package com.antony.comics.business.exception;

public class ObjetoJaCadastradoException extends RuntimeException {

    public ObjetoJaCadastradoException(String msg) {
        super(msg);
    }

    public ObjetoJaCadastradoException(String msg, Throwable cause) {
        super(msg,cause);
    }
}

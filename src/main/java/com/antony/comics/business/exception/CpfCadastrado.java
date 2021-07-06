package com.antony.comics.business.exception;

public class CpfCadastrado extends RuntimeException{

    public CpfCadastrado(String msg){
        super(msg);
    }
    public CpfCadastrado(String msg, Throwable cause) {
        super(msg,cause);
    }
}

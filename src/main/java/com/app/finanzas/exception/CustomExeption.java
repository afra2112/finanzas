package com.app.finanzas.exception;

public class CustomExeption extends RuntimeException{

    private String message;

    public CustomExeption(String message){
        super(message);
        this.message = message;
    }

    public String getMessaage(){
        return message;
    }
}

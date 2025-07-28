package com.gretacvdl.carapi.carapi.exception;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException (String message){
        super(message);
    }
}

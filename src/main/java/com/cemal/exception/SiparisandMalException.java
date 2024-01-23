package com.company.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private final EerrorType type;

    public UserException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public UserException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}

package com.company.exception;

import lombok.Getter;

@Getter
public class CompanyException extends RuntimeException{
    private final EerrorType type;

    public CompanyException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public CompanyException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}

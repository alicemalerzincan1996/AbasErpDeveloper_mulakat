package com.cemal.exception;

import lombok.Getter;

@Getter
public class SiparisandMalException extends RuntimeException{
    private final EerrorType type;

    public SiparisandMalException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public SiparisandMalException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}

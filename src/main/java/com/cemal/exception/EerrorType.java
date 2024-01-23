package com.cemal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EerrorType {
    Mal_BULUNAMADI(1003,"Bu idi ait mal bulunamadi ",NOT_FOUND),
    Siparis_BULUNAMADI(1004,"Bu idi ait siparis bulunamadi ",NOT_FOUND),
    Company_BULUNAMADI(1003,"Bu idi ait sirket bulunamadi ",NOT_FOUND),
    User_Usernamekulaniliyor(1004,"Bu Username kullaniliyor ", BAD_REQUEST),
    CompanyName_CompanyNamekulaniliyor(1004,"Bu CompanyName kullaniliyor ", BAD_REQUEST);


    private int code;
    private String mesaj;
    private HttpStatus status;
}

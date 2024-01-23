package com.company.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EerrorType {
    User_BULUNAMADI(1003,"Bu idi ait birisi bulunamadi ",NOT_FOUND),
    Company_BULUNAMADI(1003,"Bu idi ait sirket bulunamadi ",NOT_FOUND),
    User_Usernamekulaniliyor(1004,"Bu Username kullaniliyor ", BAD_REQUEST),
    CompanyName_CompanyNamekulaniliyor(1004,"Bu CompanyName kullaniliyor ", BAD_REQUEST);


    private int code;
    private String mesaj;
    private HttpStatus status;
}

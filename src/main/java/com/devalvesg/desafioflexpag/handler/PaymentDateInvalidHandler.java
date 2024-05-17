package com.devalvesg.desafioflexpag.handler;

import com.devalvesg.desafioflexpag.exceptions.PaymentBadRequest;
import com.devalvesg.desafioflexpag.exceptions.PaymentDateInvalid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaymentDateInvalidHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(PaymentDateInvalid.class)
    public String handler(PaymentDateInvalid ex){
        return ex.getMessage();
    }
}

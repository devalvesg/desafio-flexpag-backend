package com.devalvesg.desafioflexpag.handler;

import com.devalvesg.desafioflexpag.exceptions.PaymentBadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaymentBadRequestHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(PaymentBadRequest.class)
    public String handler(PaymentBadRequest ex){
        return ex.getMessage();
    }
}

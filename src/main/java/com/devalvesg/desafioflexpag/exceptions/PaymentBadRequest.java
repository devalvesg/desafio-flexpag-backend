package com.devalvesg.desafioflexpag.exceptions;

public class PaymentBadRequest extends RuntimeException{
    public PaymentBadRequest(String message){
        super(message);
    }
}

package com.devalvesg.desafioflexpag.exceptions;

public class PaymentDateInvalid extends RuntimeException{
    public PaymentDateInvalid(String message){
        super(message);
    }
}

package com.devalvesg.desafioflexpag.exceptions;

public class PaymentWasMade extends RuntimeException{
    public PaymentWasMade(String message){
        super(message);
    }
}

package com.devalvesg.desafioflexpag.handler;

import com.devalvesg.desafioflexpag.exceptions.PaymentDateInvalid;
import com.devalvesg.desafioflexpag.exceptions.PaymentWasMade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaymentWasMadeHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(PaymentWasMade.class)
    public String handler(PaymentWasMade ex){
        return ex.getMessage();
    }
}

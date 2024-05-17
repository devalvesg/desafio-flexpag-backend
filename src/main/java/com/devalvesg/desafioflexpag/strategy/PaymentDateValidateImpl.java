package com.devalvesg.desafioflexpag.strategy;

import com.devalvesg.desafioflexpag.entities.Payment;
import com.devalvesg.desafioflexpag.exceptions.PaymentDateInvalid;
import com.devalvesg.desafioflexpag.repositories.PaymentRepository;
import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import lombok.SneakyThrows;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentDateValidateImpl implements CustomizePaymentStrategy{
    private PaymentRepository paymentRepository;

    public PaymentDateValidateImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @SneakyThrows
    @Override
    public void execute(PaymentRequest paymentRequest) {
        if(paymentRequest.newPayday() != null && paymentRequest.newPayday().isBefore(LocalDateTime.now())){
            throw new PaymentDateInvalid("The payment date cannot be less than the current date");

        }
        if(paymentRequest.payday() != null && paymentRequest.payday().isBefore(LocalDateTime.now())){
            throw new PaymentDateInvalid("The payment date cannot be less than the current date");
        }
    }
}

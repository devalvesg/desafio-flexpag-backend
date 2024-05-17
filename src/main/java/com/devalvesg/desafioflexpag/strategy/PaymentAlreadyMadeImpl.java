package com.devalvesg.desafioflexpag.strategy;

import com.devalvesg.desafioflexpag.entities.Payment;
import com.devalvesg.desafioflexpag.entities.Status;
import com.devalvesg.desafioflexpag.exceptions.PaymentWasMade;
import com.devalvesg.desafioflexpag.repositories.PaymentRepository;
import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentAlreadyMadeImpl implements CustomizePaymentStrategy {

    private PaymentRepository paymentRepository;
    public PaymentAlreadyMadeImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @SneakyThrows
    @Override
    public void execute(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.findById(paymentRequest.id()).get();
        if(payment.getStatus() == Status.PAID || payment.getPayday().isBefore(LocalDateTime.now())){
            throw new PaymentWasMade("Payment has already been made and cannot be changed or deleted");
        }
    }
}

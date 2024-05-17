package com.devalvesg.desafioflexpag.strategy;

import com.devalvesg.desafioflexpag.exceptions.PaymentBadRequest;
import com.devalvesg.desafioflexpag.repositories.PaymentRepository;
import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ExistingPaymentStatusImpl implements CustomizePaymentStrategy {

    private PaymentRepository paymentRepository;
    public ExistingPaymentStatusImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void execute(PaymentRequest paymentRequest) {
        if(!isExistingPayment(paymentRequest.id()) && paymentRequest.id() != null){
            throw new PaymentBadRequest("Payment ID does not exist");
        }
    }

    private boolean isExistingPayment(UUID id){
        Optional optionalPayment = paymentRepository.findById(id);
        return optionalPayment.isPresent();
    }
}

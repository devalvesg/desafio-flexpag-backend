package com.devalvesg.desafioflexpag.strategy;

import com.devalvesg.desafioflexpag.utils.PaymentRequest;

public interface CustomizePaymentStrategy {
    void execute(PaymentRequest paymentRequest);
}

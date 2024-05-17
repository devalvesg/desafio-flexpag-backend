package com.devalvesg.desafioflexpag.controllers;

import com.devalvesg.desafioflexpag.entities.Payment;
import com.devalvesg.desafioflexpag.entities.Status;
import com.devalvesg.desafioflexpag.services.PaymentService;
import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import com.devalvesg.desafioflexpag.utils.PaymentResponse;
import com.devalvesg.desafioflexpag.utils.PaymentUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController implements PaymentControllerInterface{

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public ResponseEntity schedulePayment(PaymentRequest paymentRequest) throws Exception {
        Payment paymentLoaded = paymentService.schedulePayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentLoaded.getId());
    }

    @Override
    public ResponseEntity<Status> checkStatus(UUID id) {
        Optional<Payment> paymentStatus = paymentService.checkStatus(id);
        return paymentStatus.map(payment -> ResponseEntity.ok(payment.getStatus())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PaymentResponse> updatePaymentDate(PaymentUpdateRequest paymentUpdateRequest) {
        PaymentResponse payment = paymentService.updatePaymentDate(paymentUpdateRequest);
        return ResponseEntity.ok().body(payment);
    }

    @Override
    public ResponseEntity deletePayment(UUID id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }


}

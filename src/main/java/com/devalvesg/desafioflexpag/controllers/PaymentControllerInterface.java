package com.devalvesg.desafioflexpag.controllers;

import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import com.devalvesg.desafioflexpag.utils.PaymentUpdateRequest;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface PaymentControllerInterface {

    @PostMapping("/new-payment")
    public ResponseEntity schedulePayment(@RequestBody PaymentRequest paymentRequest) throws Exception;

    @GetMapping("/check-status/{id}")
    public ResponseEntity checkStatus(@PathVariable UUID id);

    @PatchMapping("/update-payment")
    public ResponseEntity updatePaymentDate(@RequestBody PaymentUpdateRequest paymentUpdateRequest);

    @DeleteMapping("/delete-payment/{id}")
    public ResponseEntity deletePayment(@PathVariable UUID id);
}

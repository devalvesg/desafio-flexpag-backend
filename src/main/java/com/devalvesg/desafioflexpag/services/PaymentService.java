package com.devalvesg.desafioflexpag.services;

import com.devalvesg.desafioflexpag.entities.Payment;
import com.devalvesg.desafioflexpag.entities.Status;
import com.devalvesg.desafioflexpag.repositories.PaymentRepository;
import com.devalvesg.desafioflexpag.strategy.CustomizePaymentStrategy;
import com.devalvesg.desafioflexpag.strategy.ExistingPaymentStatusImpl;
import com.devalvesg.desafioflexpag.strategy.PaymentDateValidateImpl;
import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import com.devalvesg.desafioflexpag.utils.PaymentResponse;
import com.devalvesg.desafioflexpag.utils.PaymentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private final List<CustomizePaymentStrategy> customizePaymentStrategy;
    private final ExistingPaymentStatusImpl existingPaymentStatus;

    private final PaymentDateValidateImpl paymentDateValidate;
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          List<CustomizePaymentStrategy> customizePaymentStrategy,
                          ExistingPaymentStatusImpl existingPaymentStatus,
                          PaymentDateValidateImpl paymentDateValidate){
        this.paymentDateValidate = paymentDateValidate;
        this.paymentRepository = paymentRepository;
        this.customizePaymentStrategy = customizePaymentStrategy;
        this.existingPaymentStatus = existingPaymentStatus;
    }
    public Payment schedulePayment(PaymentRequest paymentRequest) throws Exception {
            paymentDateValidate.execute(paymentRequest);
            Payment newPayment = new Payment(paymentRequest);
            newPayment.setStatus(Status.PENDING);
            Payment paymentSave = paymentRepository.save(newPayment);
            return paymentSave;

    }

    public Optional<Payment> checkStatus(UUID id){
        PaymentRequest paymentRequest = new PaymentRequest(id, null, null, null, null);
        existingPaymentStatus.execute(paymentRequest);
        return paymentRepository.findById(id);
    }

    public PaymentResponse updatePaymentDate(PaymentUpdateRequest paymentUpdateRequest) {
        PaymentRequest paymentRequest = new PaymentRequest(paymentUpdateRequest.id(), null, null, null, paymentUpdateRequest.newPayday());
        customizePaymentStrategy.forEach(validation -> validation.execute(paymentRequest));
        Payment updatedPayment = paymentRepository.findById(paymentUpdateRequest.id()).get();
        updatedPayment.setPayday(paymentUpdateRequest.newPayday());
        PaymentResponse paymentResponse = new PaymentResponse(paymentRepository.save(updatedPayment));
        return paymentResponse;
    }

    public void deletePayment(UUID id) {
        PaymentRequest paymentRequest = new PaymentRequest(id, null, null, null, null);
        customizePaymentStrategy.forEach(validation -> validation.execute(paymentRequest));
        paymentRepository.deleteById(id);
    }
}

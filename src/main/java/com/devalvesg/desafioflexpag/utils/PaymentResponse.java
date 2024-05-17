package com.devalvesg.desafioflexpag.utils;

import com.devalvesg.desafioflexpag.entities.Payment;
import com.devalvesg.desafioflexpag.entities.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponse {

    private UUID Id;
    private Double totalValue;
    private Status status;
    private LocalDateTime payday;

    public PaymentResponse(Payment payment){
        this.Id = payment.getId();
        this.payday = payment.getPayday();
        this.status = payment.getStatus();
        this.totalValue = payment.getTotalValue();
    }
}

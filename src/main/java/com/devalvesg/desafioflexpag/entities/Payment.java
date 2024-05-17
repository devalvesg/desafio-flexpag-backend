package com.devalvesg.desafioflexpag.entities;

import com.devalvesg.desafioflexpag.utils.PaymentRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tb_payments")
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private Double totalValue;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime payday;

    public Payment(PaymentRequest paymentRequest){
        this.totalValue = paymentRequest.totalValue();
        this.payday = paymentRequest.payday();
    }
}

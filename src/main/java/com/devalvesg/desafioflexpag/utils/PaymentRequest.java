package com.devalvesg.desafioflexpag.utils;

import com.devalvesg.desafioflexpag.entities.Status;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public record PaymentRequest (UUID id, Double totalValue, Status status, LocalDateTime payday, LocalDateTime newPayday) {
}

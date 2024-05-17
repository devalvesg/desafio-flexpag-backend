package com.devalvesg.desafioflexpag.utils;

import java.time.LocalDateTime;
import java.util.UUID;


public record PaymentUpdateRequest(UUID id, LocalDateTime newPayday) {
}

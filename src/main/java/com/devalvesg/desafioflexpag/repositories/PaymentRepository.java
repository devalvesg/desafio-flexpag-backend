package com.devalvesg.desafioflexpag.repositories;

import com.devalvesg.desafioflexpag.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = """
UPDATE tb_payments SET status = 'PAID' WHERE status = 'PENDING' AND payday <= NOW()
""")
    void updateStatusPayment();
}

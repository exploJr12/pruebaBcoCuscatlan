package com.work.work.domain.dto.payment;

import com.work.work.domain.model.Payment;

import java.time.LocalDateTime;

public record DtoPaymentResponse(

        Long id,
        Double amount,
        String paymentMethod,
        String status,
        LocalDateTime paymentDate

) {

    public DtoPaymentResponse(Payment payment) {

        this(
                payment.getId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getPaymentDate()
        );
    }
}
package com.work.work.domain.dto.payment;

import jakarta.validation.constraints.NotNull;

public record DtoPayment(

        @NotNull
        Long orderId,

        @NotNull
        Double amount,

        @NotNull
        String paymentMethod

) {
}
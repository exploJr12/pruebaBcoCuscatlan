package com.work.work.domain.dto.orderdetail;

import jakarta.validation.constraints.NotNull;

public record DtoOrderDetail(

        @NotNull
        Long orderId,

        @NotNull
        Long productId,

        @NotNull
        Integer quantity,

        @NotNull
        Double price

) {
}
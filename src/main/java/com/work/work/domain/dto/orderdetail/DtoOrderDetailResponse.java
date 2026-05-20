package com.work.work.domain.dto.orderdetail;

import com.work.work.domain.model.OrderDetail;

public record DtoOrderDetailResponse(

        Long id,
        Long productId,
        Integer quantity,
        Double price,
        Double subtotal

) {

    public DtoOrderDetailResponse(OrderDetail detail) {

        this(
                detail.getId(),
                detail.getProductId(),
                detail.getQuantity(),
                detail.getPrice(),
                detail.getSubtotal()
        );
    }
}
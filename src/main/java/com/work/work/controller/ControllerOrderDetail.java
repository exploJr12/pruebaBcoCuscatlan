package com.work.work.controller;

import com.work.work.domain.dto.orderdetail.DtoOrderDetail;
import com.work.work.domain.dto.orderdetail.DtoOrderDetailResponse;

import com.work.work.domain.model.OrderDetail;

import com.work.work.domain.repository.RepositoryCarrito;
import com.work.work.domain.repository.RepositoryOrderDetail;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order-detail")
@RequiredArgsConstructor
@Transactional

@Tag(
        name = "Order Detail Controller",
        description = "Controller for order details"
)

public class ControllerOrderDetail {

    private final RepositoryOrderDetail repositoryOrderDetail;
    private final RepositoryCarrito repositoryCarrito;

    @GetMapping("show")
    public ResponseEntity<List<DtoOrderDetailResponse>> show() {

        return ResponseEntity.ok(
                repositoryOrderDetail.findAll()
                        .stream()
                        .map(DtoOrderDetailResponse::new)
                        .toList()
        );
    }

    @PostMapping("create")
    public ResponseEntity<?> create(
            @RequestBody @Valid DtoOrderDetail dtoOrderDetail
    ) {

        var order = repositoryCarrito.findById(dtoOrderDetail.orderId());

        if (order.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Order not found");
        }

        var detail = repositoryOrderDetail.save(

                new OrderDetail(
                        order.get(),
                        dtoOrderDetail.productId(),
                        dtoOrderDetail.quantity(),
                        dtoOrderDetail.price()
                )
        );

        return ResponseEntity.ok(
                new DtoOrderDetailResponse(detail)
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        var detail = repositoryOrderDetail.getReferenceById(id);

        repositoryOrderDetail.delete(detail);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("unit/{id}")
    public ResponseEntity<?> unit(@PathVariable Long id) {

        var detail = repositoryOrderDetail.getReferenceById(id);

        return ResponseEntity.ok(
                new DtoOrderDetailResponse(detail)
        );
    }
}
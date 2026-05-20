package com.work.work.controller;

import com.work.work.domain.dto.payment.DtoPayment;
import com.work.work.domain.dto.payment.DtoPaymentResponse;

import com.work.work.domain.model.Carrito;

import com.work.work.domain.repository.RepositoryCarrito;
import com.work.work.domain.repository.RepositoryPayment;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
@Transactional

@Tag(
        name = "Payment Controller",
        description = "Controller for payment simulation"
)

public class ControllerPayment {

    private final RepositoryPayment repositoryPayment;
    private final RepositoryCarrito repositoryCarrito;

    @GetMapping("show")
    public ResponseEntity<List<DtoPaymentResponse>> show() {

        return ResponseEntity.ok(
                repositoryPayment.findAll()
                        .stream()
                        .map(DtoPaymentResponse::new)
                        .toList()
        );
    }

    @PostMapping("process")
    public ResponseEntity<?> process(
            @RequestBody @Valid DtoPayment dtoPayment
    ) {

        var order = repositoryCarrito.findById(dtoPayment.orderId());

        if (order.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Order not found");
        }

        Carrito carrito = order.get();

        carrito.setEstado("PAID");

        var payment = repositoryPayment.save(

                new com.work.work.domain.model.Payment(
                        carrito,
                        dtoPayment.amount(),
                        dtoPayment.paymentMethod()
                )
        );

        return ResponseEntity.ok(
                new DtoPaymentResponse(payment)
        );
    }

    @GetMapping("unit/{id}")
    public ResponseEntity<?> unit(@PathVariable Long id) {

        var payment = repositoryPayment.getReferenceById(id);

        return ResponseEntity.ok(
                new DtoPaymentResponse(payment)
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        var payment = repositoryPayment.getReferenceById(id);

        repositoryPayment.delete(payment);

        return ResponseEntity.noContent().build();
    }
}
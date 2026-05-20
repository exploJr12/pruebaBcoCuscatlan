package com.work.work.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient.Builder webClientBuilder;

    private final String URL = "https://fakestoreapi.com/products";

    public Object obtenerProductos() {

        return webClientBuilder.build()
                .get()
                .uri(URL)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }

    public Object obtenerProducto(Long id) {

        return webClientBuilder.build()
                .get()
                .uri(URL + "/" + id)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
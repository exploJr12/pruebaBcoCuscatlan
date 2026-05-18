package com.work.work.infra.errores;

import org.springframework.validation.FieldError;

public record DtoErrorData(
        String campo,
        String mensaje
) {
    public DtoErrorData(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}

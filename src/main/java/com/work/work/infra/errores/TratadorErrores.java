package com.work.work.infra.errores;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity campoVacio(MethodArgumentNotValidException e){
        var errores=e.getFieldErrors().stream().map(DtoErrorData::new).toList();
        return ResponseEntity.ok(errores);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity datoNulo(){
        return ResponseEntity.notFound().build();
    }

}

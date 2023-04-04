/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.controller;

import com.rym.exception.RequestException;
import com.rym.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Controlador que se encargará de capturar las Exceptions
@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorModel> runtimeExceptionHandler(RequestException ex){
        ErrorModel error = new ErrorModel( ex.getCode(), ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
        
        
    }
    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<ErrorModel> runtimeExceptionHandler(NumberFormatException ex){
        ErrorModel error = new ErrorModel("005", HttpStatus.BAD_REQUEST, "Parámetro debe ser numérico");
        return new ResponseEntity<>(error, error.getStatus());
        
        
    }
}

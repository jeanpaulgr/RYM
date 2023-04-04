/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author admin
 */
//Modelo Output de Errores
//Estructura de salida para el manejo de errores
@Data
public class ErrorModel {
    private String code;
    private String message;
    private HttpStatus status;
    
    public ErrorModel(String code, HttpStatus status, String message) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
    
}

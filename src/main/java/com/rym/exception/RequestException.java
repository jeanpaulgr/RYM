/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Clase que extiende de Runtime Error, para personalizar un tipo de Exception
//que nos permita manejar code, status y messagge
@Data
public class RequestException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public RequestException(String code, HttpStatus status ,String message){
       super(message); 
       this.code = code;       
       this.status = status;

    }
    
}

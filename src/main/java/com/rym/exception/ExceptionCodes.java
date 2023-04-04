/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.exception;

import com.rym.model.ErrorModel;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Clase para definir códigos, estados y mensajes de Excpetion
@Data
public class ExceptionCodes {
        public static ErrorModel RYM_GLOBAL_APP_0001 = new ErrorModel("001", HttpStatus.BAD_REQUEST ,"No se pudo ejecutar la operación"); 
        public static ErrorModel RYM_EXCEPTION_APP_0002 = new ErrorModel("002",HttpStatus.NOT_FOUND,"Objeto no encontrado");
        public static ErrorModel RYM_EXCEPTION_APP_0003 = new ErrorModel("003",HttpStatus.INTERNAL_SERVER_ERROR,"Error Interno en el Servidor");
        public static ErrorModel RYM_EXCEPTION_APP_0004 = new ErrorModel("004",HttpStatus.NOT_IMPLEMENTED,"EndPoint no implementado");
}

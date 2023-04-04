/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.implementation;


import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Clase utilizada para contener variables de entorno y en el caso de
//que fuesen necesarias declaración de variables o metodos en un futuro
//que fuesen utilizads por sus clases hijas de Servicio.
public abstract class ApiResponseService {
    @Value("${rym.base-url}")
    protected String baseUrl;
}

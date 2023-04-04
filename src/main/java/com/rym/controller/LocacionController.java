/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.controller;

import com.rym.model.LocacionModel;
import com.rym.service.implementation.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
@RestController
@RequestMapping("/locaciones")
public class LocacionController {
    @Autowired
    LocacionService locacionService;
    
    @GetMapping(path = "/{id}")
    //@ApiOperation(value = "Este controlador es utilizado para obtener una LOCATION mediante su ID")
    public ResponseEntity<LocacionModel> locacion(@PathVariable("id") Integer id ){
       LocacionModel response  = this.locacionService.getLocationById(id);
       return new ResponseEntity<>(response, HttpStatus.OK);
    } 
}

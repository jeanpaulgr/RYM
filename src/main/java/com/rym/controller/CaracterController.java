/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rym.model.CaracterModel;
import com.rym.service.implementation.CaracterService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *
 * @author jeanpaulgr@gmail.com
 */
@RestController
@RequestMapping("/caracters")
public class CaracterController {
    @Autowired
    CaracterService caracterService;

    //@ApiOperation(value = "Este controlador es utilizado para obtener 1 CHARACTER")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CaracterModel> caracter(@PathVariable("id") Integer id){  
        CaracterModel response = this.caracterService.getCaracter(id);
        return new ResponseEntity<>(response, response.getId() != 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    //@ApiOperation(value = "Este controlador es utilizado para obtener todos los CHARACTERS que nos permite la API de Rick And Morty en su consulta sin parámetros (20)")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<CaracterModel> caracter(){  
        return this.caracterService.getCaractersAll();
    }
}

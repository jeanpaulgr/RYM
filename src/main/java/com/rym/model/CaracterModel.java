/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.model;

import lombok.Data;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Modelo Output de Caracter 
//(Esta es la estructura de salida del EndPoint caracters)
@Data
public class CaracterModel {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episode_count;
    private LocacionModel origin;
}

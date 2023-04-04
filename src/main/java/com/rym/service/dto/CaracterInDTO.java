/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.dto;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Modelo Input de Caracter 
//Esta es la estructura con la que se recibe la data desde API Rick And Morty
@Data
public class CaracterInDTO {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginInDTO origin;
    private LocacionInDTO location;
    private String image;
    private ArrayList<String> episode;
    private String url;   
    private String created;
    private String error;
}

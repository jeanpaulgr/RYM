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
//Modelo Input de Locacion 
//Esta es la estructura con la que se recibe la data desde API Rick And Morty
@Data
public class LocacionInDTO {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private ArrayList<String> residents;
    private String url;
    private String created;
}

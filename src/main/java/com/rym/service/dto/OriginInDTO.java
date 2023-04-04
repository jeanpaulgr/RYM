/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.dto;

import lombok.Data;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Modelo Input de Origin contenida por CaracterModel 
//Esta es la estructura con la que se recibe la data desde API Rick And Morty
@Data
public class OriginInDTO {
    private String name;
    private String url;
}

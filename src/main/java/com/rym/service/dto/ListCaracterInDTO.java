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
//Modelo Input de Lista de caracteres (todos los characters desde API) 
//Esta es la estructura con la que se recibe la data desde API Rick And Morty
@Data
public class ListCaracterInDTO {
    
    ArrayList<CaracterInDTO> results;
}

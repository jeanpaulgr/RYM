/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.model;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author admin
 */
//Modelo Output de Locacion 
//(Esta es la estructura de salida del EndPoint locaciones)
@Data
public class LocacionModel {
    private String name;
    private String url;
    private String dimension;
    private ArrayList<String> residents;
    //Por defecto se creará con Name 'Unknow'
    
    public LocacionModel(){
        setName("unknow");
    }
}

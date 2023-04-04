/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.declaration;

import java.util.ArrayList;
import com.rym.model.LocacionModel;
/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Declaracion de Interfaz de Servicio (LocacionService)
public interface ILocacionService {
     //Funciones de caracter
    public ArrayList<LocacionModel> getLocationsAll();    
    public LocacionModel getLocationById(int id);    
    public LocacionModel getLocationByURL(String Url);

 
}

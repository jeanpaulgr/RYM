/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.declaration;

import java.util.ArrayList;
import com.rym.model.CaracterModel;
/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Declaracion de Interfaz de Servicio (CaracterService)
public interface ICaracterService {
 
    public ArrayList<CaracterModel> getCaractersAll();    
    public CaracterModel getCaracter(int id);
 
}

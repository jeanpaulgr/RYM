/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.mapper;
import com.rym.model.LocacionModel;
import com.rym.service.dto.LocacionInDTO;
import org.springframework.stereotype.Component;
/**
 *
 * @author admin
 */
//Componente que mapea un modelo LocacionInDTO (estructura de entrada de API de Rick And Morty) a un LocacionModel (estructura de salida de API nuestra)
@Component
public class LocacionInDTOToLocacion implements IMapper<LocacionInDTO, LocacionModel> {

    @Override
    public LocacionModel map(LocacionInDTO in) {
       LocacionModel locacion = new LocacionModel();
        
        locacion.setName(in.getName());
        locacion.setUrl(in.getUrl());
        locacion.setDimension(in.getDimension());
        locacion.setResidents(in.getResidents());

        return locacion;
    }
    
}

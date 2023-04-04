/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.mapper;

import org.springframework.stereotype.Component;
import com.rym.service.dto.CaracterInDTO;
import com.rym.model.CaracterModel;
import com.rym.service.implementation.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Componente que mapea un modelo CaracterInDTO (estructura de entrada de API de Rick And Morty) a un CaraterModel (estructura de salida de API nuestra)
@Component
public class CaracterInDTOToCaracter implements IMapper<CaracterInDTO, CaracterModel> {
@Autowired
LocacionService locacionService;
    
    @Override
    public CaracterModel map(CaracterInDTO in) {
        CaracterModel character = new CaracterModel();
        
        character.setId(in.getId());
        character.setName(in.getName());
        character.setStatus(in.getStatus());
        character.setSpecies(in.getSpecies());
        character.setType(in.getType());
        character.setEpisode_count(in.getEpisode().size());
        character.setOrigin(locacionService.getLocationByURL(in.getOrigin().getUrl()));
        return character;
    }
    
}

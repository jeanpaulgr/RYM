/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.implementation;

import com.rym.exception.ExceptionCodes;
import com.rym.exception.RequestException;
import com.rym.model.CaracterModel;
import com.rym.service.dto.CaracterInDTO;
import com.rym.service.mapper.CaracterInDTOToCaracter;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import com.rym.service.declaration.ICaracterService;
import com.rym.service.dto.ListCaracterInDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Clase de Servicio Caracter Implementada.
@Service
public class CaracterService extends ApiResponseService implements ICaracterService{

    private final CaracterInDTOToCaracter mapper;
    private final RestTemplate restTemplate;

    
    public CaracterService(CaracterInDTOToCaracter mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    //Método que obtiene todos los Caracteres
    @Override
    public ArrayList<CaracterModel> getCaractersAll() {
      Log log = LogFactory.getLog(getClass());
      String url = baseUrl + "/character/";
      ArrayList<CaracterModel> listCaracter = new ArrayList<CaracterModel>();
        try {
            ResponseEntity<ListCaracterInDTO> response = restTemplate.getForEntity(url, ListCaracterInDTO.class);
            if(response.getStatusCode().is2xxSuccessful()){
                for (CaracterInDTO caracterInDTO : response.getBody().getResults()) {
                    if(caracterInDTO != null) listCaracter.add(mapper.map(caracterInDTO));
                }
            } else{
                 log.error(ExceptionCodes.RYM_GLOBAL_APP_0001.getMessage());
                 throw new RequestException(ExceptionCodes.RYM_GLOBAL_APP_0001.getCode(),
                                            ExceptionCodes.RYM_GLOBAL_APP_0001.getStatus(),
                                            ExceptionCodes.RYM_GLOBAL_APP_0001.getMessage());
            }
        
        } catch (HttpClientErrorException e) {
            log.error(ExceptionCodes.RYM_EXCEPTION_APP_0002.getMessage() + " - " + e.getMessage());
            throw new RequestException(ExceptionCodes.RYM_EXCEPTION_APP_0002.getCode(),                  
                                       ExceptionCodes.RYM_EXCEPTION_APP_0002.getStatus(),
                                       ExceptionCodes.RYM_EXCEPTION_APP_0002.getMessage() + " - " + e.getMessage());
        } catch (Exception e2) {
            log.error(ExceptionCodes.RYM_EXCEPTION_APP_0003.getMessage() + " - " + e2.getMessage());
            throw new RequestException(ExceptionCodes.RYM_EXCEPTION_APP_0003.getCode(),                  
                                       ExceptionCodes.RYM_EXCEPTION_APP_0003.getStatus(),
                                       ExceptionCodes.RYM_EXCEPTION_APP_0003.getMessage() + " - " + e2.getMessage());
        }
        
        return listCaracter;   
    }
    //Método que obtiene un Caracter mediante su ID
    @Override
    public CaracterModel getCaracter(int id) {
      Log log = LogFactory.getLog(getClass());
      String url = baseUrl + "/character/" + id;
      CaracterModel caracter = new CaracterModel();
        try {
            ResponseEntity<CaracterInDTO> response = restTemplate.getForEntity(url, CaracterInDTO.class);
            if(response.getStatusCode().is2xxSuccessful()){
                caracter = mapper.map(response.getBody());
            } else{
                 log.error(ExceptionCodes.RYM_GLOBAL_APP_0001.getMessage());
                 throw new RequestException(ExceptionCodes.RYM_GLOBAL_APP_0001.getCode(),
                                            ExceptionCodes.RYM_GLOBAL_APP_0001.getStatus(),
                                            ExceptionCodes.RYM_GLOBAL_APP_0001.getMessage());
            }  
        } catch (HttpClientErrorException e) {
            log.error(ExceptionCodes.RYM_EXCEPTION_APP_0002.getMessage() + " - " + e.getMessage());
            throw new RequestException(ExceptionCodes.RYM_EXCEPTION_APP_0002.getCode(),                  
                                       ExceptionCodes.RYM_EXCEPTION_APP_0002.getStatus(),
                                       ExceptionCodes.RYM_EXCEPTION_APP_0002.getMessage() + " - " + e.getMessage());
        
        } catch (Exception e2) {
            log.error(ExceptionCodes.RYM_EXCEPTION_APP_0003.getMessage() + " - " + e2.getMessage());
            throw new RequestException(ExceptionCodes.RYM_EXCEPTION_APP_0003.getCode(),                  
                                       ExceptionCodes.RYM_EXCEPTION_APP_0003.getStatus(),
                                       ExceptionCodes.RYM_EXCEPTION_APP_0003.getMessage() + " - " + e2.getMessage());
        
        }

        return caracter;   
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.implementation;

import com.rym.exception.ExceptionCodes;
import com.rym.exception.RequestException;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import com.rym.service.declaration.ILocacionService;
import com.rym.model.LocacionModel;
import com.rym.service.dto.LocacionInDTO;
import com.rym.service.mapper.LocacionInDTOToLocacion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author jeanpaulgr@gmail.com
 */
//Clase de Servicio Locacion Implementada.
@Service
public class LocacionService extends ApiResponseService implements ILocacionService {

//    @Autowired
    private final LocacionInDTOToLocacion mapperLocacion;
    private final RestTemplate restTemplate;
  
    public LocacionService(LocacionInDTOToLocacion mapper, RestTemplate restTemplate) {
        this.mapperLocacion = mapper;
         this.restTemplate = restTemplate;
    }
    @Override
    public ArrayList<LocacionModel> getLocationsAll() {
        //Este método no será implementado para el requerimiento
        throw new RequestException(ExceptionCodes.RYM_EXCEPTION_APP_0004.getCode(),
                                            ExceptionCodes.RYM_EXCEPTION_APP_0004.getStatus(),
                                            ExceptionCodes.RYM_EXCEPTION_APP_0004.getMessage());
    }
    //Método que obtiene una Locacion mediante su ID
    @Override
    public LocacionModel getLocationById(int id) {
    Log log = LogFactory.getLog(getClass());
    String url = baseUrl + "/location/" + id;
      LocacionModel locacion = new LocacionModel();
        
        try {
            ResponseEntity<LocacionInDTO> response = restTemplate.getForEntity(url, LocacionInDTO.class);
            if(response.getStatusCode().is2xxSuccessful()){
                locacion = mapperLocacion.map(response.getBody());    
            }else{
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
        return locacion;    
    }
    //Método que obtiene una Locacion mediante su URL de API
    @Override
    public LocacionModel getLocationByURL(String url) {
      Log log = LogFactory.getLog(getClass());
      if(url == null || url == "") return new LocacionModel();

      LocacionModel locacion = new LocacionModel();
        try {
            ResponseEntity<LocacionInDTO> response = restTemplate.getForEntity(url, LocacionInDTO.class); 
            if(response.getStatusCode().is2xxSuccessful()){
                locacion = mapperLocacion.map(response.getBody());
                 log.info(response.getBody());
            } 
        } catch (Exception e) {
            //En caso de error, necesitamos que no se levante la exception
            //pensando en que la llamada principal viene desde Character
        }
        
        return locacion; 
    }
    
}

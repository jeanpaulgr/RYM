/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rym.service.mapper;

/**
 *
 * @author admin
 */
//interfaz Padre para el mapeo, recibe como parámetro un tipo de Entrada y otro de Salida.
public interface IMapper <I, O> {
    public O map(I in);

}

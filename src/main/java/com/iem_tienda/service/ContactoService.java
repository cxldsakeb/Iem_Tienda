/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;

import com.iem_tienda.domain.Contacto;
import java.util.List;

/**
 *
 * @author jose1
 */
public interface ContactoService {
    List<Contacto> getContactos(String nombre);

    Contacto getContacto(Contacto contacto);

    void save(Contacto contacto);

    void delete(Contacto contacto);
}

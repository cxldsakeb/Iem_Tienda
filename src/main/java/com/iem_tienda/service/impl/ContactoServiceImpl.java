/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.service.impl;

import com.iem_tienda.dao.ContactoDao;
import com.iem_tienda.domain.Contacto;
import com.iem_tienda.service.ContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose1
 */
@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getContactos(String nombre) {
         if (nombre != null && !nombre.isEmpty()) {
             return contactoDao.findByNombre(nombre);
         } else {
             return contactoDao.findAll();
         }
    }

    @Override
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    public void delete(Contacto contacto) {
         contactoDao.delete(contacto);
    }
}

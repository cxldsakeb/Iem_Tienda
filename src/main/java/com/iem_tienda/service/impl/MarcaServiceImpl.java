/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.service.impl;

import com.iem_tienda.dao.MarcaDAO;
import com.iem_tienda.domain.Marca;
import com.iem_tienda.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaDAO marcaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Marca> getMarcas() {
        return marcaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Marca getMarca(Long id) {
        return marcaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveMarca(Marca marca) {
        marcaDAO.save(marca);
    }

    @Override
    @Transactional
    public void deleteMarca(Long id) {
        marcaDAO.deleteById(id);
    }
}


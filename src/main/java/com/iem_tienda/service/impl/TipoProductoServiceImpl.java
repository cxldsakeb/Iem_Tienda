/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.service.impl;

import com.iem_tienda.dao.TipoProductoDAO;
import com.iem_tienda.domain.TipoProducto;
import com.iem_tienda.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TipoProductoServiceImpl 
        implements TipoProductoService{
    
    @Autowired
    private TipoProductoDAO tipoProductoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoProducto> getTiposProducto(boolean activo) {
        var lista=tipoProductoDAO.findAll();
        if (activo){
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public TipoProducto getTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoDAO.findById(tipoProducto.getIdTipoProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void saveTipoProducto(TipoProducto tipoProducto) {
        tipoProductoDAO.save(tipoProducto);
    }

    @Override
    @Transactional
    public void deleteTipoProducto(TipoProducto tipoProducto) {
        tipoProductoDAO.delete(tipoProducto);
    }
    
}



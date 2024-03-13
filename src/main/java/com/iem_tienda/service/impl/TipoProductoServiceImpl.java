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
public abstract class TipoProductoServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductoDAO tipoProductoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<TipoProducto> getTiposProducto() {
        return tipoProductoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoProducto getTipoProducto(Long idTipoProducto) {
        return tipoProductoDAO.findById(idTipoProducto).orElse(null);
    }

    @Transactional
    public void save(TipoProducto tipoProducto) {
        tipoProductoDAO.save(tipoProducto);
    }

    @Transactional
    public void delete(Long idTipoProducto) {
        tipoProductoDAO.deleteById(idTipoProducto);
    }
}



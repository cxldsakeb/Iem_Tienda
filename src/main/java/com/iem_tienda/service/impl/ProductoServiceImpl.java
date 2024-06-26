/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.service.impl;

import com.iem_tienda.domain.Producto;
import com.iem_tienda.service.ProductoService;
import java.util.List;
import com.iem_tienda.dao.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose1
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoDAO.findAll();
        if (activo) {
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDAO.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDAO.delete(producto);
    }

    @Override
    @Transactional
    public List<Producto> metodoJPA(double precioInf, double precioSup) {
         return productoDAO.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional
    public List<Producto> getProductoPorTipoProducto(Long tipoProductoId) {
        return productoDAO.findByTipoProducto_IdTipoProducto(tipoProductoId);
    }

    @Override
    @Transactional
    public List<Producto> getProductoPorMarca(Long marcaId) {
        return productoDAO.findByMarca_IdMarca(marcaId);
    }
}

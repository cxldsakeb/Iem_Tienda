/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iem_tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jose1
 */
public interface ProductoDAO extends JpaRepository<Producto, Long> {
    public List<Producto> findByPrecioBetweenOrderByDescripcion(
            double precioInf, double precioSup);
    
}

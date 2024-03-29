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
    
    @Query(value="SELECT p from Producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto>
            metodoJPQL(
                    double precioInf, double precioSup);
            
    @Query(nativeQuery=true,
            value="SELECT * from producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto>
            metodoSQL(
                    double precioInf, double precioSup);
}

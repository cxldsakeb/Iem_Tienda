/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.dao;

import com.iem_tienda.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoProductoDAO extends JpaRepository<TipoProducto, Long>{
    
}
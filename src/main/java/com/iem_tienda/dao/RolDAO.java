/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iem_tienda.domain.Rol;
/**
 *
 * @author jose1
 */
public interface RolDAO extends JpaRepository<Rol, Long>{
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.dao;


import com.iem_tienda.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarcaDAO extends JpaRepository<Marca, Long>{
    
}
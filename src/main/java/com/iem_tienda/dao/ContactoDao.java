/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.dao;
import com.iem_tienda.domain.Contacto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository <Contacto, Long> {
     List<Contacto> findByNombre(String nombre);

}


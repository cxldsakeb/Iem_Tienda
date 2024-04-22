/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iem_tienda.domain.Usuario;
/**
 *
 * @author jose1
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername(String username);
    
    public Usuario findByUsernameAndPassword(String username, String Password);

    public Usuario findByUsernameOrCorreo(String username, String correo);

    public boolean existsByUsernameOrCorreo(String username, String correo);
}

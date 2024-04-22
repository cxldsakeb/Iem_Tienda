/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 *
 * @author jose1
 */
public interface UsuarioDetailsService {
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
}

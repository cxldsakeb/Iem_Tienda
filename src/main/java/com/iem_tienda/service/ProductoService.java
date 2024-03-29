/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;

import java.util.List;
import com.iem_tienda.domain.Producto;
/**
 *
 * @author jose1
 */
public interface ProductoService {
    
    public List<Producto> getProductos(boolean activo);
    
    public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
    
    public void delete(Producto producto);
    
    public List<Producto> metodoJPA(double precioInf, double precioSup);
    
    public List<Producto>metodoJPQL( double precioInf, double precioSup);
            
    public List<Producto>metodoSQL(double precioInf, double precioSup);
            
    public List<Producto> metodoJPA2(int existenciasInf, int existenciasSup);
}

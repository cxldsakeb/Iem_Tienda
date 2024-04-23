/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jose1
 */
@Data
@EqualsAndHashCode(callSuper=false)

public class Item extends Producto{
    
    private int cantidad;
    
    public Item(Producto p){
        super.setActivo(p.isActivo());
        super.setDescripcion(p.getDescripcion());
        super.setIdProducto(p.getIdProducto());
        super.setMarca(p.getMarca());
        super.setNombre(p.getNombre());
        super.setPrecio(p.getPrecio());
        super.setRuta_imagen(p.getRuta_imagen());
        super.setStock(p.getStock());
        super.setTipoProducto(p.getTipoProducto());
        
        
        this.cantidad=0;
    }
}

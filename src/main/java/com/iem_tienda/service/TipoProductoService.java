/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;


import com.iem_tienda.domain.TipoProducto;
import java.util.List;

public interface TipoProductoService {

    // Obtener todos los tipos de producto
    public List<TipoProducto> getTiposProducto();

    // Obtener un tipo de producto por su ID
    public TipoProducto getTipoProducto(Long id);

    // Guardar o actualizar un tipo de producto
    public void saveTipoProducto(TipoProducto tipoProducto);

    // Eliminar un tipo de producto
    public void deleteTipoProducto(Long id);
}

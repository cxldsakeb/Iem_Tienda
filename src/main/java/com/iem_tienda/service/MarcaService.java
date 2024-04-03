/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;


import com.iem_tienda.domain.Marca;
import java.util.List;

public interface MarcaService {

    // Obtener todas las marcas
    public List<Marca> getMarcas(boolean activo);

    // Obtener una marca por su ID
    public Marca getMarca(Marca marca);

    // Guardar o actualizar una marca
    public void saveMarca(Marca marca);

    // Eliminar una marca
    public void deleteMarca(Marca marca);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author jose1
 */

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long IdProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String ruta_imagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_producto")
    private TipoProducto tipoProducto;
    
    @ManyToOne
    @JoinColumn(name="id_marca")
    private Marca marca;
}

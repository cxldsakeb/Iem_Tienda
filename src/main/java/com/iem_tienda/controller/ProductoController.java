/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.controller;

import com.iem_tienda.domain.Producto;
import com.iem_tienda.service.ProductoService;
import com.iem_tienda.service.TipoProductoService;
import com.iem_tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jose1
 */
@Controller
@RequestMapping("/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private TipoProductoService tipoProductoService;

    // "/producto/listado"
    @GetMapping("/")
    public String listado(Model model) {

        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());

        //Para poder hacer los options del select...
        var tipoProductos = tipoProductoService.getTiposProducto(true);
        model.addAttribute("tipoProductos", tipoProductos);

        return "index";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            //Se debe subir la imagen
            productoService.save(producto);
            String ruta_imagen = firebaseStorageServiceImpl.cargaImagen(imagenFile, "producto", producto.getIdProducto());
            producto.setRuta_imagen(ruta_imagen);

        }
        productoService.save(producto);

        return "redirect:/producto/listado";

    }

    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model) {
        //Para poder hacer los options del select...
        var tipoProductos = tipoProductoService.getTiposProducto(true);
        model.addAttribute("categorias", tipoProductos);
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String elimina(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

}

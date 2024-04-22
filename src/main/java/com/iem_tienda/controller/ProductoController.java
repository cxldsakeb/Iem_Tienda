/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.controller;

import com.iem_tienda.domain.Marca;
import com.iem_tienda.domain.Producto;
import com.iem_tienda.domain.TipoProducto;
import com.iem_tienda.service.ProductoService;
import com.iem_tienda.service.TipoProductoService;
import com.iem_tienda.service.MarcaService;
import com.iem_tienda.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
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
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private TipoProductoService tipoProductoService;
    @Autowired
    private MarcaService marcaService;

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
    
    @GetMapping("/queryTipos/{idTipoProducto}")
    public String queryTipos(TipoProducto tipoProducto,Model model) {
        tipoProducto = tipoProductoService.getTipoProducto(tipoProducto);
        var productos = tipoProducto.getProductos();
        model.addAttribute("productos", productos);
  
        //Para poder hacer los options del select...
        var tipoProductos = tipoProductoService.getTiposProducto(true);
        model.addAttribute("tipoProductos", tipoProductos);
        
        return "index";
    }
    
    @GetMapping("/queryMarcas/{idMarca}")
    public String queryMarcas(Marca marca,Model model) {
        marca = marcaService.getMarca(marca);
        var productos = marca.getProductos();
        model.addAttribute("productos", productos);
  
        //Para poder hacer los options del select...
        var marcas = marcaService.getMarcas(true);
        model.addAttribute("marcas", marcas);
        
        return "index";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;
    
    @PostMapping("/query1")
    public String consultaquery(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model){
        
        var lista = productoService.metodoJPA(precioInf,precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "index";
    }
    
    @GetMapping("/productoPorTipoProducto")
    public String productoPorTipoProducto(@RequestParam(name = "idTipoProducto", required = false) Long idTipoProducto, Model model) {
        List<Producto> productos;
        if (idTipoProducto != null) {
            productos = productoService.getProductoPorTipoProducto(idTipoProducto);
        } else {
            productos = productoService.getProductos(true); // Obtener todos los juegos
        }
        model.addAttribute("productos", productos);

        // Obtener todas las categorías y agregarlas al modelo
        List<TipoProducto> tipoProductos = tipoProductoService.getTiposProducto(true);
        model.addAttribute("tipoProductos", tipoProductos);

        return "index"; // Ruta correcta para la vista de juegos
    }
    @GetMapping("/productoPorMarca")
    public String productoPorMarca(@RequestParam(name = "idMarca", required = false) Long idMarca, Model model) {
        List<Producto> productos;
        if (idMarca != null) {
            productos = productoService.getProductoPorMarca(idMarca);
        } else {
            productos = productoService.getProductos(true); // Obtener todos los juegos
        }
        model.addAttribute("productos", productos);

        // Obtener todas las categorías y agregarlas al modelo
        List<Marca> marcas = marcaService.getMarcas(true);
        model.addAttribute("marcas", marcas);

        return "index"; // Ruta correcta para la vista de juegos
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
        return "redirect:/producto/listado2";
    }
    

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

        return "redirect:/producto/listado2";

    }

}

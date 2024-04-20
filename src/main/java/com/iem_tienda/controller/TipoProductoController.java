/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.controller;



import com.iem_tienda.domain.TipoProducto;
import com.iem_tienda.service.TipoProductoService;
import com.iem_tienda.service.impl.FirebaseStorageServiceImpl;
//import com.tienda_m.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/tipo-producto")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    // "/tipo-producto/listado"
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = tipoProductoService.getTiposProducto(false);
        model.addAttribute("tiposProducto", lista);
        model.addAttribute("totalTiposProducto", lista.size());
        return "/agregartipo/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @PostMapping("/guardar")
    public String guardar(TipoProducto tipoProducto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Se debe subir la imagen
            tipoProductoService.saveTipoProducto(tipoProducto);
            String rutaImagen = firebaseStorageServiceImpl.cargaImagen(imagenFile, "tipo-producto", tipoProducto.getIdTipoProducto());
            tipoProducto.setRutaImagen(rutaImagen);
        }
        tipoProductoService.saveTipoProducto(tipoProducto);
        return "redirect:/tipo-producto/listado";
    }

    @GetMapping("/modificar/{idTipoProducto}")
    public String modifica(TipoProducto tipoProducto, Model model) {
        tipoProducto = tipoProductoService.getTipoProducto(tipoProducto);
        model.addAttribute("tipoProducto", tipoProducto);
        return "/agregartipo/modifica";
    }

    @GetMapping("/eliminar/{idTipoProducto}")
    public String elimina(TipoProducto tipoProducto) {
        tipoProductoService.deleteTipoProducto(tipoProducto);
        return "redirect:/tipo-producto/listado";
    }
    }
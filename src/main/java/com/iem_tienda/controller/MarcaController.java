/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.controller;



import com.iem_tienda.domain.Marca;
import com.iem_tienda.service.MarcaService;
import com.iem_tienda.service.impl.FirebaseStorageServiceImpl;
import com.iem_tienda.service.impl.MarcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/marca")
public class MarcaController {

@Autowired
    private MarcaService marcaService;

    // "/tipo-producto/listado"
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = marcaService.getMarcas(false);
        model.addAttribute("marca", lista);
        model.addAttribute("t", lista.size());
        return "/marca/listado";
    }

    
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @PostMapping("/guardar")
    public String guardar(Marca marca,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            //Se debe subir la imagen
            marcaService.saveMarca(marca);
            String ruta_imagen = firebaseStorageServiceImpl.cargaImagen(imagenFile, "marca", marca.getIdMarca());
            marca.setRuta_imagen(ruta_imagen);

        }
        marcaService.saveMarca(marca);

        return "redirect:/marca/listado";

    }

    @GetMapping("/modificar/{idMarca}")
    public String modifica(Marca marca, Model model) {
        marca = marcaService.getMarca(marca);
        model.addAttribute("marca", marca);
        return "/marca/modifica";
    }

    @GetMapping("/eliminar/{idMarca}")
    public String elimina(Marca marca) {
        marcaService.deleteMarca(marca);
        return "redirect:/marca/listado";
    }
}
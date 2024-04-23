/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iem_tienda.controller;

import com.iem_tienda.domain.Contacto;
import com.iem_tienda.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jose1
 */
@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contactos")
    public String mostrarPaginaContacto(Model model) {
        var contactos = contactoService.getContactos(null);
        model.addAttribute("contactos", contactos);
        return "contacto/listado";
    }

    @PostMapping("/guardar")
    public String guardarContacto(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/contacto/contactos";
    }

    @GetMapping("/eliminar/{idContacto}")
    public String contactoEliminar(Contacto contacto) {
        contactoService.delete(contacto);
        return "redirect:/contacto/contactos";
    }
}

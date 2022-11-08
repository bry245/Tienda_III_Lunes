/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3QL.controller;

import com.Tienda_3QL.domain.Articulo;
import com.Tienda_3QL.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinda
 */
@Controller
public class ArticuloController {
    
    @Autowired
    private  ArticuloService articuloService;
    
     
     
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);/*Metodo del crud que devulve todos los articulos*/
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";/*Retorna a que vista de templates llamar*/
    }
    
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo){
        
        return "/articulo/modificar";
    }
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")/*Este metodo no se utiliza*/
    public String modificarArticulo(Articulo articulo, Model model){
        articulo= articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";    
    }
    
        
    
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo ,Model model){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
    
    
    
    
    
    
}

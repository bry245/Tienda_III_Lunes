/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3QL.controller;

import com.Tienda_3QL.domain.Categoria;
import com.Tienda_3QL.service.CategoriaService;
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
public class CategoriaController {
    
    @Autowired
    private  CategoriaService categoriaService;
    
     
     
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);/*Metodo del crud que devulve todos los categorias*/
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";/*Retorna a que vista de templates llamar*/
    }
    
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria){
        
        return "/categoria/modificar";
    }
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")/*Este metodo no se utiliza*/
    public String modificarCategoria(Categoria categoria, Model model){
        categoria= categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";    
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria ,Model model){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    
    
    
    
    
    
}

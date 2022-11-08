/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3QL.controller;

import com.Tienda_3QL.domain.Cliente;
import com.Tienda_3QL.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClienteController {
    
    @Autowired
    private  ClienteService clienteService;
    
     
     
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getCliente();/*Metodo del crud que devulve todos los clientes*/
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";/*Retorna a que vista de templates llamar*/
    }
    
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        
        return "/cliente/modificar";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")/*Este metodo no se utiliza*/
    public String modificarCliente(Cliente cliente, Model model){
        cliente= clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";    
    }
    
        
    
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente ,Model model){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    
    
    
    
    
}

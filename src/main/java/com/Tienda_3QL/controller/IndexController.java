package com.Tienda_3QL.controller;

import com.Tienda_3QL.dao.ClienteDao;
import com.Tienda_3QL.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
/*Hace la etiqueta de controlador*/
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;

    /*Para ir al index(home)*/
    @GetMapping("/")

    public String inicio(Model model) {
        // model.addAttribute("attribute", "value");
        log.info("Ahora se usa arquitectura MVC");
        Cliente cliente = new Cliente("Pedro", "Gomez Contreras", "pgomez@gmail.com", "6090-8818");

        //Cliente cliente2=new Cliente("Rebeca","Alguras Salas","ArgueRebe@gmail.com","6090-8818");
        //var clientes=Arrays.asList(cliente,cliente2);
        var clientes = clienteDao.findAll();/*Metodo del crud*/


        model.addAttribute("clientes", clientes);
        return "index";/*Retorna a que vista de templates llamar*/
    }

}

package com.Tienda_3QL.controller;


import com.Tienda_3QL.dao.ArticuloDao;
import com.Tienda_3QL.domain.Articulo;
import com.Tienda_3QL.service.ArticuloService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
/*Hace la etiqueta de controlador*/
public class IndexController {

    @Autowired
    private ArticuloService articuloService;

    /*Para ir al index(home)*/
    @GetMapping("/")

    public String inicio(Model model) {
        
        log.info("Ahora se usa arquitectura MVC");
        var articulos = articuloService.getArticulos(true);/*Metodo del crud que devulve todos los articulos*/

        model.addAttribute("articulos", articulos);
        return "index";/*Retorna a que vista de templates llamar*/
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.url.paginaweb.service.PagosService;

/**
 *
 * @author alici
 */
@Controller
@Slf4j
public class PagosController {
    @Autowired
    private PagosService service;
    
    @GetMapping("pagos/metodo-pago")
    public String getMetodoPago(Model model){
        model.addAttribute("metodos", service.getMetodoPago().getResults());
        return ("pagos/metodoPago");
    };
     @GetMapping("pagos/agregar-tarjeta")
    public String getAgregarTarjeta(){
        return ("pagos/agregarTarjeta");
    };
        @GetMapping("pagos/devolucion")
    public String getDevolucion(){
        return ("pagos/devoluciones");
    }; 
          @GetMapping("pagos/devolucion-aceptada")
    public String getDevolucionAceptada(){
        return ("pagos/devolucionAceptada");
    }; 
}

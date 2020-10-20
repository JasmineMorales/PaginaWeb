/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.url.paginaweb.modelo.MetodoPago;
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
    
    @GetMapping("pagos/agregar-metodo-pago")
    public String getAgregarMetodoPago(Model model){
        model.addAttribute("metodoPago", new MetodoPago());
        return ("pagos/agregarMetodoPago");
    };
    
    @PostMapping("pagos/metodo-pago")
    public String postAgregarMetodoPago(@ModelAttribute MetodoPago metodoPago, Model model){
        model.addAttribute("metodoPago", metodoPago);
        System.out.println(metodoPago.getTipo());
        System.out.println(metodoPago.getDisponibilidad());
        
        service.postMetodoPago(metodoPago);
        
        model.addAttribute("metodos", service.getMetodoPago().getResults());
        return("pagos/metodoPago");
    }
    
    @RequestMapping(value ="pagos/addMetodoPago", method = RequestMethod.PATCH)
    public void submit(@Valid @ModelAttribute("metodoPago") MetodoPago metodoPago,
            BindingResult result, ModelMap model){
        
        
        System.out.println(metodoPago.getDisponibilidad());
        
    }
}

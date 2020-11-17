package org.url.paginaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.Envio;
import org.url.paginaweb.modelo.enviosBusqueda;
import org.url.paginaweb.service.EnviosService;
import org.url.paginaweb.service.LoginPService;
import org.url.paginaweb.service.MainsiteService;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alici
 */
@Controller
public class EnviosController {
    
    @Autowired 
    private EnviosService service;
    
    @Autowired
    private LoginPService login;
    
    @GetMapping("/envios/estado-envio")
    public String getEnviosEstados() {
        return("envios/envio");
    };
    @GetMapping("/envios/estado-envio-repartidor")
    public String getEnviosEstadosRepartidor(@ModelAttribute Envio envio, Model model) {
        model.addAttribute("envio", envio);
        return("envios/envioRepartidor");
    };
    
    @PostMapping("/envios/estado-envio-repartidor")
    public String putEnviosEstadosRepartidor(@ModelAttribute Envio envio, Model model) {
        
        Envio respuesta = service.putEnvio(envio.getId(), envio);
        
        model.addAttribute("envio", envio);
        return("envios/envioRepartidor");
    };
    @GetMapping("/envios/busqueda")
    public String getBusqueda(@ModelAttribute enviosBusqueda enviosBusqueda, Model model) {
        model.addAttribute("enviosBusqueda", enviosBusqueda);
        
        return("envios/busqueda");
    };
    @PostMapping("/envios/busqueda")
    public String postBusqueda(@ModelAttribute Envio envio, Model model, Authentication user){
        Envio data = service.getEnvio(envio.getId());
        model.addAttribute("envio", data);
        
        String tipo = login.getTipoUser(user.getAuthorities());
        
        switch(tipo){
            case MainsiteService.ADMIN:
                return("envios/envioRepartidor");
            case MainsiteService.CLIENTE:
                return("envios/envio");
            case MainsiteService.REPARTIDOR:
                return("envios/envioRepartidor");
            default:
                return("envios/envio");
        }
        
    };
}

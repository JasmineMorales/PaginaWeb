/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloUsuario;
import org.url.paginaweb.modelo.Usuario;

/**
 *
 * @author marcos
 */
@Controller
@Slf4j
public class MainSiteController {
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/")
    public String getMainPage(Model model){
        
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/1/";
        Usuario respuesta = restTemplate.getForObject(url, Usuario.class);
        log.info(respuesta.toString());
        
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/";
        ArregloUsuario response1 = restTemplate.getForObject(url1, ArregloUsuario.class);
        log.info(response1.toString());
        
        return("/MainSite/index");
    }
}

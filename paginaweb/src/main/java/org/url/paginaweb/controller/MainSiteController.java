/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;


import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.url.paginaweb.modelo.Admin;
import org.url.paginaweb.modelo.Repartidor;
import org.url.paginaweb.modelo.Usuario;
import org.url.paginaweb.service.LoginPService;
import org.url.paginaweb.service.MainsiteService;

/**
 *
 * @author marcos
 */
@Controller
@Slf4j
public class MainSiteController {
    
    @Autowired
    private MainsiteService mainsiteService;
    
    @Autowired
    private LoginPService loginService;
    
    @GetMapping("/")
    public String getMainPage(Model model, Authentication user){
       return("MainSite/index");
    }
    
    @GetMapping("/usuarios/registro")
    public String getRegistroUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "MainSite/registrarusuario";
    }
    
    @PostMapping("/usuarios/registrar")
    public String regitrarUsuario(Model model, @Valid Usuario usuario, Errors errores){
        if(errores.hasErrors()){
            
            model.addAttribute("usuario", usuario);
            return "MainSite/registrarusuario";
        }
        usuario.setToken("string");
        loginService.insertarUsuario(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/repartidor/registro")
    public String getRegistroRepartidor(Model model){
        model.addAttribute("repartidor", new Repartidor());
        return "MainSite/registrarrepartidor";
    }
    
    @PostMapping("/repartidor/registrar")
    public String registrarRepartidor(Model model, @Valid Repartidor repartidor, Errors errores){
        if(errores.hasErrors()){
            model.addAttribute("repartidor", repartidor);
            return "MainSite/registrarrepartidor";
        }
        repartidor.setDisponibilidad(true);
        repartidor.setEstado(true);
        loginService.insertarRepartidor(repartidor);
        return "redirect:/";
    }
    
    @GetMapping("/administrador/registro")
    public String getRegistroAdministrador(Model model){
        model.addAttribute("admin", new Admin());
        return "MainSite/registraradmin";
    }
    
    @PostMapping("/administrador/registrar")
    public String registrarAdmin(Model model, @Valid Admin admin, Errors errores){
        log.info(admin.toString());
        if(errores.hasErrors()){
            model.addAttribute("admin", admin);
            return "MainSite/registraradmin";
        }
        
        loginService.insertarAdmin(admin);
        return "redirect:/";
    }
}

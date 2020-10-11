/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.url.paginaweb.modelo.Usuario;
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
    
    @GetMapping("/")
    public String getMainPage(Model model){
        return("MainSite/index");
    }
}

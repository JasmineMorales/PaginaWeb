/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Gilda
 */
@Controller
public class VentasController {

            @GetMapping("/Ventas/index")
    public String getVentaPage(){
        return("/Ventas/index");
    }

            @GetMapping("/Ventas/canceladas")
    public String getVentaCanceladaPage(){
        return("/Ventas/canceladas");
    }
    
            @GetMapping("/Ventas/enespera")
    public String getVentaenesperaPage(){
        return("/Ventas/enespera");
    }
    
            @GetMapping("/Ventas/entregadas")
    public String getVentaPageentregada(){
        return("/Ventas/entregadas");
    }
                @GetMapping("/Ventas/seleccionada")
    public String getVentaSeleccionada(){
        return("/Ventas/ventaespecifica");
    }
    }

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
public class ComprasController {

            @GetMapping("/Compras/index")
    public String getCompraPage(){
        return("/Compras/index");
    }

    
            @GetMapping("/Compras/carrito")
    public String getCarritoPage(){
        return("/Compras/carrito");}

        
            @GetMapping("/Compras/pago")
    public String getPagoCompraPage(){
        return("/Compras/pagocompra");
    }
    }

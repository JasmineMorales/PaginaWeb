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
 * @author jasmine
 */
@Controller
public class ProductosController {
    
    @GetMapping("/producto")
    public String getProductPage(){
        return("/Productos/producto");
    }

    
            @GetMapping("/Productos/agregar_producto")
    public String getAddProductPage(){
        return("/Productos/agregar_producto");}

        
            @GetMapping("/Productos/producto")
    public String getProductListPage(){
        return("/Productos/producto");
    }
}
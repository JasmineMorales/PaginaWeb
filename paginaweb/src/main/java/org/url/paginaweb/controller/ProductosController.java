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
    
    @GetMapping("/Productos/productos")
    public String getProductPage(){
        return("/Productos/vistaProductos");
    }
    
        @GetMapping("Productos/modificar_producto")
    public String getEditProductPage(){
        return("/Productos/modificarProducto");
    }
    
            @GetMapping("/Productos/agregar_producto")
    public String getAddProductPage(){
        return("/Productos/agregarProducto");}

        
            @GetMapping("/Productos/producto")
    public String getProductListPage(){
        return("/Productos/producto");
    }
}
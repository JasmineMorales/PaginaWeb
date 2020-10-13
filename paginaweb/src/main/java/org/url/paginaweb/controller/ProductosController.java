/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.url.paginaweb.service.ProductService;
/**
 *
 * @author jasmine
 */
@Controller
@Slf4j
public class ProductosController {
    int id;
    @Autowired
    private ProductService productService;
    
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
        //productService.getAllProducts();
        return("/Productos/producto");
    }
}
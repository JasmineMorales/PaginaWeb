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
import org.springframework.web.bind.annotation.RequestParam;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.service.ProductService;
/**
 *
 * @author jasmine
 */
@Controller
@Slf4j
public class ProductosController {
    //int id;
    @Autowired
    private ProductService productService;
    
    @GetMapping("/Productos/productos")
    public String getProductPage(Model model){
        List productos = productService.getAllProducts();
        model.addAttribute("productos", productos);
        return("/Productos/vistaProductos");
    }
           
        @GetMapping("Productos/modificar_producto")
    public String getEditProductPage(){
        return("/Productos/modificarProducto");
    }
    
    @GetMapping("/Productos/agregar_producto")
    public String getAddProductPage(){
        return("/Productos/agregarProducto");
    }
    
           /* @PostMapping("/Productos/agregar_producto")
    public String postAddProductPage(@ModelAttribute Producto producto, Model model){
        model.addAttribute("producto", producto);
        System.out.println(producto.getNombre());
        System.out.println(producto.getPrecio());
        productService.postProduct(producto);
        model.addAttribute("productos", productService.getAllProducts().getResults());
        return("/Productos/agregarProducto");}*/

        
            @GetMapping("/Productos/producto")
    public String getProductListPage(@RequestParam(name="variable1", required=true, defaultValue = "1") int id, Model model){
        model.addAttribute("id", id);
        Producto producto = productService.getProductID(id);
        model.addAttribute("producto", producto);
       List comentarios = productService.getAllComentarios();
       model.addAttribute("comentarios", comentarios);
        return("/Productos/producto");
    }
}
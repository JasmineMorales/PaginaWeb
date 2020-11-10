/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.url.paginaweb.modelo.Carrito;
import org.url.paginaweb.modelo.DetalleCarro;
import org.url.paginaweb.modelo.DetalleCarroC;
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
    public String getProductPage(Model model) {
        List productos = productService.getAllProducts();
        model.addAttribute("productos", productos);
        System.out.println("************");
        Carrito carro = productService.GetCarros();

        return ("/Productos/vistaProductos");
    }

    /*@GetMapping("Productos/modificar_producto")
    public String getEditProductPage(){
        return("/Productos/modificarProducto");
    }*/
    @GetMapping("/Productos/agregar_producto")
    public String getAddProductPage(@ModelAttribute Producto producto, Model model) {
        List proveedores = productService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        List tipoproductos = productService.getAllTipos();
        model.addAttribute("tipoproductos", tipoproductos);
        model.addAttribute("producto", producto);
        return ("/Productos/agregarProducto");
    }

    @PostMapping("/Productos/agregar_producto")
    public String postAddProductPage(@ModelAttribute Producto producto, Model model) {
        model.addAttribute("producto", producto);
        List proveedores = productService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        List tipoproductos = productService.getAllTipos();
        model.addAttribute("tipoproductos", tipoproductos);
        productService.postProduct(producto);
        return ("/Productos/agregarProducto");
    }

    @GetMapping("/Productos/producto")
    public String getProductListPage(@RequestParam(name = "variable1", required = true, defaultValue = "1") int id, Model model) {
        model.addAttribute("id", id);
        Producto producto = productService.getProductID(id);
        model.addAttribute("producto", producto);
        List comentarios = productService.getAllComentarios();
        model.addAttribute("comentarios", comentarios);
        List proveedores = productService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        DetalleCarroC dt = new DetalleCarroC();
        //detalle
        Carrito carro = productService.GetCarros();
        dt.setCarro(carro.getId());
        dt.setCantidad(0);
        dt.setProducto(producto.getId());
        model.addAttribute("dt", dt);
        return ("/Productos/producto");
    }

    @PostMapping("/Productos/producto")
    public String greetingSubmit(@ModelAttribute DetalleCarroC detalle, Model model) throws JsonProcessingException {
                
                detalle.setCantidad(0);
                detalle.setId(1);
                detalle.setSubtotal(0f);
               
        productService.SetDetalleCarro(detalle);
        return ("/Productos/vistaProductos");
    }

    @GetMapping("/Productos/producto/modificar_producto")
    public String getModProduct(@RequestParam(name = "variable1", required = true, defaultValue = "1") int id, Model model) {
        model.addAttribute("id", id);
        Producto producto = productService.getProductID(id);
        model.addAttribute("producto", producto);
        List proveedores = productService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        List tipoproductos = productService.getAllTipos();
        model.addAttribute("tipoproductos", tipoproductos);
        return ("/Productos/modificarProducto");
    }
}

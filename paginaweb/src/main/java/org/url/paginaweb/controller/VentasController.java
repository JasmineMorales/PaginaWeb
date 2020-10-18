/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.url.paginaweb.modelo.DetalleVenta;
import org.url.paginaweb.modelo.Venta;
import org.url.paginaweb.service.VentasService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.url.paginaweb.modelo.ArregloDetalleVenta;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Usuario;

/**
 *
 * @author Gilda
 */
@Controller
@Slf4j
public class VentasController {

    @Autowired
    private VentasService ventaService;

    @GetMapping("/Ventas/index")
    public String getVentaPage(Model model) {
        List ventas = ventaService.GetVentas();
        model.addAttribute("ventas", ventas);
        return ("/Ventas/index");
    }

    @GetMapping("/Ventas/canceladas")
    public String getVentaCanceladaPage(Model model) {
        List ventas = ventaService.GetVentas();
        model.addAttribute("ventas", ventas);
        return ("/Ventas/canceladas");
    }

    @GetMapping("/Ventas/enespera")
    public String getVentaenesperaPage(Model model) {
        List ventas = ventaService.GetVentas();
        model.addAttribute("ventas", ventas);
        return ("/Ventas/enespera");
    }

    @GetMapping("/Ventas/entregadas")
    public String getVentaPageentregada(Model model) {
        List ventas = ventaService.GetVentas();
        model.addAttribute("ventas", ventas);
        return ("/Ventas/entregadas");
    }

    // @GetMapping("/Ventas/seleccionada")
    // public String getVentaSeleccionada() {
    //     Venta venta = ventaService.GetVenta(1);
    //     log.info(venta.toString());
    //     return ("/Ventas/ventaespecifica");
    // }
    @GetMapping("/Ventas/seleccionada")
    public String getVentaSeleccionada(@RequestParam(name = "variable1", required = true, defaultValue = "1") int id, Model model) {
        model.addAttribute("id", id);
        Venta venta = ventaService.GetVenta(id);
        model.addAttribute("venta", venta);
        //obtiene todos los detalles
        List<DetalleVenta> detalle = ventaService.GetDetalleVenta();
        //recibe solo los detalles de la venta seleccionada
        List<DetalleVenta> detallenuevo = DetallesVentaID(detalle, id);
        //agrega 
      //  model.addAttribute("detalle", detallenuevo);
        //productos
        List<Producto> productos = NombresProductos(detallenuevo);
        List<DetalleVenta> detallesmodelo = ObtenerNombresProductos(productos,detallenuevo);
        
      //  model.addAttribute("productos", productos);
      model.addAttribute("detalle", detallesmodelo);
        return ("/Ventas/ventaespecifica");
    }

    //METODOS PARA FILTRAR POR INFORMACION ESPECIFICA
    //DETALLES DE VENTA ESPECIFICA, SI ES DETALLE DE LA VENTA SELECCIONADA SE AGREGA A LA LISTA
    public List<DetalleVenta> DetallesVentaID(List<DetalleVenta> dventa, int id) {
        List<DetalleVenta> dnventa = new ArrayList<DetalleVenta>();
        DetalleVenta detalle = null;
        for (int x = 0; x < dventa.size(); x++) {
            detalle = dventa.get(x);
            if (detalle.getVenta() == id) {
                dnventa.add(detalle);
            } else {
                //dventa.remove(x);
            }
            detalle = null;
        }
        return (dnventa);
    }

    //OBTENER LOS  PRODUCTOS
    public List<Producto> NombresProductos(List<DetalleVenta> dventa) {
        List<Producto> nproductos = new ArrayList<Producto>();
        DetalleVenta detalle = null;
        for (int x = 0; x < dventa.size(); x++) {
            detalle = dventa.get(x);
            int idproducto = detalle.getProducto();
            Producto producto = ventaService.GetProducto(idproducto);
            nproductos.add(producto);
            
        }
        return nproductos;
    }
    
    
    //OBTENER LOS NOMBRES DE LOS PRODUCTOS
    public List<DetalleVenta> ObtenerNombresProductos(List<Producto> producto, List<DetalleVenta> venta) {
        List<Producto> nproductos = new ArrayList<Producto>();
        for (int x = 0; x < producto.size(); x++) {
            Producto p = producto.get(x);
            String nombre = p.getNombre();
            DetalleVenta d = venta.get(x);
            d.setNombre(nombre);
            venta.set(x, d);
        }
        return venta;
    }
    

}

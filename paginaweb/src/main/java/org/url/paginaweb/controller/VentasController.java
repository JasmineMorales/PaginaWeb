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
import org.url.paginaweb.modelo.DetalleVenta;
import org.url.paginaweb.modelo.Venta;
import org.url.paginaweb.service.VentasService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.url.paginaweb.modelo.ArregloDetalleVenta;
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
        //ArregloDetalleVenta detalle = ventaService.GetDetalleVenta(id);
        List detalle = ventaService.GetDetalleVenta();
        //DetalleVenta detalle = ventaService.GetDetalle(id);
        model.addAttribute("detalle", detalle);
        //Usuario user = ventaService.GetVentaUser(1);
        //model.addAttribute("cliente",user);
        return ("/Ventas/ventaespecifica");
    }
}

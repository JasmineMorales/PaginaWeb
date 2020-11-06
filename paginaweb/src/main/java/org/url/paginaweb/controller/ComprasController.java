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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.url.paginaweb.modelo.ArregloDetalleCarro;
import org.url.paginaweb.modelo.Carrito;
import org.url.paginaweb.modelo.DetalleCarro;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Venta;
import org.url.paginaweb.service.CompraService;

/**
 *
 * @author Gilda
 */
@Controller
@Slf4j
public class ComprasController {

    @Autowired
    CompraService compraService;

    @GetMapping("/Compras/index")
    public String getCompraPage() {
        return ("/Compras/index");
    }

    @GetMapping("/Compras/carrito")
    public String getCarritoPage(Model model) {
        //obtengo el carro segun el id
        try{
        Carrito carro = compraService.GetCarroe(1);
        //obtengo los detalles del carro
         List<DetalleCarro> detalles = compraService.GetDetalle();
         //Solo los detalles del carro
         List<DetalleCarro> detallesC = getDetalles(detalles, carro.getId());
        //nombres de productos
        List<String> nombresp = DetallesCarro(detallesC);
        model.addAttribute("detalles", detallesC);
        model.addAttribute("nombres", nombresp);
        return ("/Compras/carrito");
        }
        catch(Exception e){
        return ("/Compras/NoHayCarro");    
        }
        
    }

    @GetMapping("/Compras/pago")
    public String getPagoCompraPage(Model model) {
        model.addAttribute("venta", new Venta());
        return ("/Compras/pagocompra");
    }

    @PostMapping("/Compras/carrito")
    public String greetingSubmit(@ModelAttribute Venta venta, Model model) {
        model.addAttribute("venta", venta);
        return ("/Compras/carrito");
    }

    //METODOS DE OBTENCION DE DATOS
    //obtener nombres de los productos
    public List DetallesCarro(List<DetalleCarro> detalle) {
        List<String> nombres = new ArrayList();
        int size = detalle.size();
        for (int x = 0; x < size; x++) {
            DetalleCarro d1 = detalle.get(x);
            //obtener id de producto
            int producto = d1.getProducto();
            //obtener el producto con ese id
            Producto p = compraService.GetProducto(producto);
            nombres.add(p.getNombre());
        }

        return nombres;
    }
    //separando detalles por id de carro
    public List getDetalles(List <DetalleCarro> detalle, int id){
        int size= detalle.size();
        List<DetalleCarro> det = new ArrayList();
        for(int x=0;x<size;x++){
        DetalleCarro d1 = detalle.get(x);
        int idd= d1.getCarro();
        if(idd==id){
            det.add(d1);
        }
        else{
            
        }
    }
        return det;
    }
}

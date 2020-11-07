/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.url.paginaweb.modelo.VentaC;
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

    @GetMapping("/Compras/confirmar")
    public String confirmarCompra() {
        return ("/Compras/confirmarCompra");
    }

    @GetMapping("/Compras/compraRealizada")
    public String realizadaCompra() {
             
        return ("/Compras/compraRealizada");
    }

    
    @GetMapping("/Compras/carrito")
    public String getCarritoPage(@RequestParam(name="variable1", required=true, defaultValue="1") int id, Model model){
        //obtengo el carro segun el id
        try {
            Carrito carro = compraService.GetCarroe(id);
            //obtengo los detalles del carro
            List<DetalleCarro> detalles = compraService.GetDetalle();
            //Solo los detalles del carro
            List<DetalleCarro> detallesC = getDetalles(detalles, carro.getId());
            //nombres de productos
            detallesC = DetallesCarro(detallesC);
            model.addAttribute("detalles", detallesC);
            float total = Calcular(detallesC);
            model.addAttribute("total", total);
            return ("/Compras/carrito");
        } catch (Exception e) {
            return ("/Compras/NoHayCarro");
        }

    }

    @PostMapping("/Compras/pago")
    public String greetingSubmit(@RequestParam(name="variable1", required=true, defaultValue="1") int id, @ModelAttribute VentaC venta, Model model) {

        try {
            //CREACION DE VENTA
            
            Carrito carro = compraService.GetCarroe(id);
            //obtengo los detalles del carro
            List<DetalleCarro> detalles = compraService.GetDetalle();
            //Solo los detalles del carro
            List<DetalleCarro> detallesC = getDetalles(detalles, carro.getId());
            //nombres de productos
            detallesC = DetallesCarro(detallesC);
            float total = Calcular(detallesC);
            //ID DEL CLIENTE--------------------
            venta.setCliente(carro.getUsuario());
            //TOTAL
            venta.setTotal(total);

            
            //REPARTIDOR
             int re = valRepartidor();
            venta.setRepartidor(re);
            //CODIGO
            String c = valCodigo();
            venta.setCodigo(c);
            //FORMA DE PAGO
            //ESTADO            
            venta.setEstado("En espera");
            //venta.setFormaPago(1);
            //DESCUENTO-------------------------------------
            float d = 0;
            venta.setDescuento(d);

            
            //CREAR DETALLE VENTA
            
            for(int x=0;x<detallesC.size();x++){
                compraService.deleteDetalleCarrito(detallesC.get(x));
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //CREAR VENTA
         compraService.SetVenta(venta);
         //ELIMINAR EL CARRO
         compraService.deleteCarrito(1);
            return ("/Compras/compraRealizada");
        } catch (Exception e) {
            return ("/Compras/index");
        }
    }

    @GetMapping("/Compras/pago")
    public String getPagoCompraPage(@RequestParam(name="variable1", required=true, defaultValue="1") int id, Model model) {
        try {
            Carrito carro = compraService.GetCarroe(id);
            //obtengo los detalles del carro
            List<DetalleCarro> detalles = compraService.GetDetalle();
            //Solo los detalles del carro
            List<DetalleCarro> detallesC = getDetalles(detalles, carro.getId());
            //nombres de productos
            detallesC = DetallesCarro(detallesC);
            model.addAttribute("detalles", detallesC);
            float total = Calcular(detallesC);
            model.addAttribute("total", total);
            model.addAttribute("venta", new VentaC());
            return ("/Compras/pagocompra");
        } catch (Exception e) {
            return ("/Compras/NoHayCarro");
        }


    }


    //METODOS DE OBTENCION DE DATOS
    //obtener nombres de los productos
    public List DetallesCarro(List<DetalleCarro> detalle) {
        int size = detalle.size();
        List<DetalleCarro> detalle1 = new ArrayList();
        for (int x = 0; x < size; x++) {
            DetalleCarro d1 = detalle.get(x);
            //obtener id de producto
            int producto = d1.getProducto();
            //obtener el producto con ese id
            Producto p = compraService.GetProducto(producto);
            d1.setNombreProducto(p.getNombre());
            d1.setPrecio(p.getPrecio());
            d1.setSubtotal(d1.getPrecio() * d1.getCantidad());
            detalle1.add(d1);
        }

        return detalle1;
    }

    //separando detalles por id de carro
    public List getDetalles(List<DetalleCarro> detalle, int id) {
        int size = detalle.size();
        List<DetalleCarro> det = new ArrayList();
        for (int x = 0; x < size; x++) {
            DetalleCarro d1 = detalle.get(x);
            int idd = d1.getCarro();
            if (idd == id) {
                det.add(d1);
            } else {

            }
        }
        return det;
    }

    public float Calcular(List<DetalleCarro> detalle) {
        int size = detalle.size();
        float total = 0;
        for (int x = 0; x < size; x++) {
            DetalleCarro d = detalle.get(x);
            total += d.getSubtotal();
        }
        return total;
    }
    
    
    public int valRepartidor(){
        List repartidor = compraService.GetRepartidor();
        int size = repartidor.size();
         int valorDado = (int) Math.floor(Math.random()* (size+1));
        return valorDado;
    }
    
    
        public String valCodigo(){
         int valorDado = (int) Math.floor(Math.random()*500);
         int valorDado1 = (int) Math.floor(Math.random()*100);
         String c = valorDado + "" + valorDado1;
        return c;
    }
}

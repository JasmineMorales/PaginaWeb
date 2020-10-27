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
import org.url.paginaweb.modelo.Repartidor;
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
    public String getVentaPage(Model model) { //recibe el modelo
        // creo una lista que recibira lo que devuelva el service
        try {
            List ventas = ventaService.GetVentas();
            ventas = NombresRepartidores(ventas);// este metodo lo use para obtener los nombres de los repartidores ignoralo
            model.addAttribute("ventas", ventas);//agrego al modelo la lista ventas
            return ("/Ventas/index");
        } catch (Exception e) {
            return ("/Ventas/NoHayVentas");
        }

    }

    @GetMapping("/Ventas/canceladas")
    public String getVentaCanceladaPage(Model model) {
        try {
            List ventas = ventaService.GetVentas();
            if (ventas.size() == 0) {
                return ("/Ventas/NoHayVentas");
            } else {
                List<Venta> ventanueva = VentasCanceladas(ventas);
                if (ventanueva.size() == 0) {
                    return ("/Ventas/NoHayVentas");
                } else {
                    
                    ventanueva = NombresRepartidores(ventanueva);
                    model.addAttribute("ventas", ventanueva);
                    return ("/Ventas/canceladas");
                }
            }

        } catch (Exception e) {
            return ("/Ventas/NoHayVentas");
        }

    }

    @GetMapping("/Ventas/enespera")
    public String getVentaenesperaPage(Model model) {
        try {
            List ventas = ventaService.GetVentas();
            if (ventas.size() == 0) {
                return ("/Ventas/NoHayVentas");
            } else {
                List<Venta> ventanueva = VentasEspera(ventas);
                 
                if (ventanueva.size() == 0) {
                    return ("/Ventas/NoHayVentas");
                } else {

                    ventanueva = NombresRepartidores(ventanueva);
                    model.addAttribute("ventas", ventanueva);
                    return ("/Ventas/enespera");
                }
            }
        } catch (Exception e) {
            return ("/Ventas/NoHayVentas");
        }
    }

    @GetMapping("/Ventas/entregadas")
    public String getVentaPageentregada(Model model) {
        try {
            List ventas = ventaService.GetVentas();
            if (ventas.size() == 0) {
                return ("/Ventas/NoHayVentas");
            } else {
                List<Venta> ventanueva = VentasEntregadas(ventas);
                if (ventanueva.size() == 0) {
                    return ("/Ventas/NoHayVentas");
                }
                else{
                ventanueva = NombresRepartidores(ventanueva);
                model.addAttribute("ventas", ventanueva);
                return ("/Ventas/entregadas");}
            }
        } catch (Exception e) {
            return ("/Ventas/NoHayVentas");
        }
    }

    @GetMapping("/Ventas/seleccionada")
    public String getVentaSeleccionada(@RequestParam(name = "variable1", required = true, defaultValue = "1") int id, Model model) {
        try {
            model.addAttribute("id", id);
            Venta venta = ventaService.GetVenta(id);
            venta = NombresUsuario(venta);
            model.addAttribute("venta", venta);
            //obtiene todos los detalles
            List<DetalleVenta> detalle = ventaService.GetDetalleVenta();
            if(detalle.size() == 0){
                return ("/Ventas/SinProducto");
            }
            else{
            //recibe solo los detalles de la venta seleccionada
            List<DetalleVenta> detallenuevo = DetallesVentaID(detalle, id);
            List<Producto> productos = NombresProductos(detallenuevo); //AQUIII
            List<DetalleVenta> detallesmodelo = ObtenerNombresProductos(productos, detallenuevo);
            //model.addAttribute("productos", productos);
            model.addAttribute("detalle", detallesmodelo);
            return ("/Ventas/ventaespecifica");}
        } catch (Exception e) {

            return ("/Ventas/SinProducto");
        }
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

    //VENTA CANCELADOS
    public List<Venta> VentasCanceladas(List<Venta> dventa) {
        List<Venta> dnventa = new ArrayList<Venta>();
        for (int x = 0; x < dventa.size(); x++) {
            Venta v = dventa.get(x);
            if ((v.getEstado().equals("Cancelada")) || (v.getEstado().equals("Cancelado"))) {
                dnventa.add(v);
            } else {
                dventa.remove(x);
            }

        }
        return (dnventa);
    }

    //VENTA ENTREGADOS
    public List<Venta> VentasEntregadas(List<Venta> dventa) {
        List<Venta> dnventa = new ArrayList<Venta>();
        for (int x = 0; x < dventa.size(); x++) {
            Venta v = dventa.get(x);
            if ((v.getEstado().equals("Entregado"))||(v.getEstado().equals("Entregada"))) {
                dnventa.add(v);
            } else {
                dventa.remove(x);
            }

        }
        return (dnventa);
    }
    //VENTA ESPERA

    public List<Venta> VentasEspera(List<Venta> dventa) {
        List<Venta> dnventa = new ArrayList<Venta>();
        for (int x = 0; x < dventa.size(); x++) {
            Venta v = dventa.get(x);
            if ((v.getEstado().equals("En espera")) || (v.getEstado().equals("Espera"))){
                dnventa.add(v);
            } else {
                dventa.remove(x);
            }

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

    //OBTENER LOS NOMBRES DE LOS PRODUCTOS, 
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

    //OBTENER El usuario y repartidor para venta especifica
    public Venta NombresUsuario(Venta dventa) {
        int usuario = dventa.getCliente();
        Usuario u = ventaService.GetUsuario(usuario);
        dventa.setNombreUsuario(u.getNombre());
        int rep = dventa.getRepartidor();
        Repartidor r = ventaService.GetRepartidor(rep);
        dventa.setNombreRepartidor(r.getNombre());
        return dventa;
    }

    //OBTENER el nombre de repartidor lisa ventas
    public List<Venta> NombresRepartidores(List<Venta> dventa) {
        for (int x = 0; x < dventa.size(); x++) {
            Venta v = dventa.get(x);
            int rep = v.getRepartidor();
            Repartidor r = ventaService.GetRepartidor(rep);
            String nombre = r.getNombre();
            v.setNombreRepartidor(nombre);
            dventa.set(x, v);
        }

        return dventa;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloDetalleVenta;
import org.url.paginaweb.modelo.ArregloVenta;
import org.url.paginaweb.modelo.DetalleVenta;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Usuario;
import org.url.paginaweb.modelo.Venta;

/**
 *
 * @author Gilda
 */
@Service
public class VentasService{
    @Autowired
    private RestTemplate restTemplate;

        public Venta GetVenta(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/" + id + "/";
        Venta response1 = restTemplate.getForObject(url, Venta.class);
        return response1;
    }
        public List GetVentas(){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/";
        ArregloVenta response1 = restTemplate.getForObject(url, ArregloVenta.class);
        List<Venta> respuesta = response1.getResults();
        return respuesta;
    }
    public List<DetalleVenta> GetDetalleVenta(){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventa/";
        ArregloDetalleVenta response1 = restTemplate.getForObject(url, ArregloDetalleVenta.class);
        List<DetalleVenta> respuesta = response1.getResults();
        return respuesta;
    }
       public DetalleVenta GetDetalle(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventa/"+ id +"/";
        DetalleVenta response1 = restTemplate.getForObject(url, DetalleVenta.class);
        return response1;
    }
       
       //SERVICE PARA NOMBRES DE PRODUCTOS
        public Producto GetProducto(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/" + id + "/";
        Producto response1 = restTemplate.getForObject(url, Producto.class);
        return response1;
    }
        

}

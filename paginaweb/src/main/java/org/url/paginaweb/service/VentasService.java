/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloDetalleVenta;
import org.url.paginaweb.modelo.ArregloVenta;
import org.url.paginaweb.modelo.DetalleVenta;
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

    public ArregloDetalleVenta GetDetalleVenta(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventa/"+ id +"/";
        ArregloDetalleVenta response1 = restTemplate.getForObject(url, ArregloDetalleVenta.class);
        return response1;
    }

        public Usuario GetVentaUser(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/" + id + "/";
        Usuario response1 = restTemplate.getForObject(url, Usuario.class);
        return response1;
    }
        
       public DetalleVenta GetDetalle(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventa/"+ id +"/";
        DetalleVenta response1 = restTemplate.getForObject(url, DetalleVenta.class);
        return response1;
    }

}

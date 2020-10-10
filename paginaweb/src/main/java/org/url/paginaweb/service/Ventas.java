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

/**
 *
 * @author Gilda
 */
@Service
public class Ventas{
    @Autowired
    private RestTemplate restTemplate;

        public ArregloVenta GetVenta(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/ventas/" + id;
        ArregloVenta response1 = restTemplate.getForObject(url1, ArregloVenta.class);
        return response1;
    }

    public ArregloDetalleVenta GetDetalleVenta(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventas/" + id;
        ArregloDetalloVenta response1 = restTemplate.getForObject(url1, ArregloDetalleVenta.class);
        return response1;
    }
}

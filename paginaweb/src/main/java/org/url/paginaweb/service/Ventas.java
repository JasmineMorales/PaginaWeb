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


/**
 *
 * @author Gilda
 */
@Service
public class Ventas{
    @Autowired
    private RestTemplate restTemplate;
        //String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/";
        //ArregloDetalleVenta response1 = restTemplate.getForObject(url1, ArregloDetalleVenta.class);
        //log.info(response1.toString());
}

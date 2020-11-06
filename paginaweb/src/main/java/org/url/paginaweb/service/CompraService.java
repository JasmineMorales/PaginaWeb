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
import org.url.paginaweb.modelo.ArregloDetalleCarro;
import org.url.paginaweb.modelo.Carrito;
import org.url.paginaweb.modelo.DetalleCarro;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Venta;

/**
 *
 * @author tito88
 */
@Service
public class CompraService {

    @Autowired
    private RestTemplate restTemplate;

    public Carrito GetCarroe(int id) {
        //Esto cambiarlo, porque este pide por medio del id del carro, que en realidad no tenemos
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/carro/" + id + "/";
        Carrito response1 = restTemplate.getForObject(url, Carrito.class);
        return response1;
    }

    public List GetDetalle() {
        //Esto cambiarlo, porque este pide por medio del id del carro, que en realidad no tenemos
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detallecarro/";
        ArregloDetalleCarro response1 = restTemplate.getForObject(url, ArregloDetalleCarro.class);
        List<DetalleCarro> respuesta = response1.getResults();
        return respuesta;
    }

    public Producto GetProducto(int id) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/" + id + "/";
        Producto response1 = restTemplate.getForObject(url, Producto.class);
        return response1;
    }

}

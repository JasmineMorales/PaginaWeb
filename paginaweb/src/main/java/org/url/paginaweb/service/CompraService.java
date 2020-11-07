/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloDetalleCarro;
import org.url.paginaweb.modelo.ArregloRepartidor;
import org.url.paginaweb.modelo.ArregloVenta;
import org.url.paginaweb.modelo.Carrito;
import org.url.paginaweb.modelo.DetalleCarro;
import org.url.paginaweb.modelo.DetalleVenta;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Repartidor;
import org.url.paginaweb.modelo.Venta;
import org.url.paginaweb.modelo.VentaC;

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

    public void SetVenta(VentaC venta) throws JsonProcessingException {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/";
        VentaC result = restTemplate.postForObject(url, venta, VentaC.class);

    }

    public void SetDetalleVenta(DetalleVenta venta) throws JsonProcessingException {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detalleventa/";
        DetalleVenta result = restTemplate.postForObject(url, venta, DetalleVenta.class);

    }

    public List GetRepartidor() {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/repartidor/";
        ArregloRepartidor response1 = restTemplate.getForObject(url, ArregloRepartidor.class);
        List<Repartidor> respuesta = response1.getResults();
        return respuesta;
    }

    public void deleteCarrito(int id) {
        restTemplate.delete("http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/carro/" + id + "/");
    }

    public void deleteDetalleCarrito(DetalleCarro dv) {
        restTemplate.delete("http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detallecarro/" + dv.getId() + "/");
    }

    public List GetVentas() {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/";
        ArregloVenta response1 = restTemplate.getForObject(url, ArregloVenta.class);
        List<Venta> respuesta = response1.getResults();
        return respuesta;
    }
}

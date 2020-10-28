package org.url.paginaweb.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloComentario;
import org.url.paginaweb.modelo.ArregloProducto;
import org.url.paginaweb.modelo.Comentario;
import org.url.paginaweb.modelo.Producto;

/**
 *
 * @author jasmine
 */
@Service
@Slf4j
public class ProductService {
    
    @Autowired
    private RestTemplate restTemplate;

    public Producto getProductID(int id) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/" + id + "/";
        Producto respuesta = restTemplate.getForObject(url, Producto.class);
        return respuesta;
    }

    public List getAllProducts() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        ArregloProducto response1 = restTemplate.getForObject(url1, ArregloProducto.class);
        List<Producto> respuesta = response1.getResults();
        return respuesta;
    }
    
    public List getAllComentarios() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/comentario/";
        ArregloComentario response1 = restTemplate.getForObject(url1, ArregloComentario.class);
        List<Comentario> respuesta = response1.getResults();
        return respuesta;
    }
    
    
    public void postProduct(Producto producto){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        Producto result = restTemplate.postForObject(url, producto, Producto.class);
        System.out.println(result);
    }
    
    public void putProduct(Producto producto){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        Producto result = restTemplate.postForObject(url, producto, Producto.class);
        System.out.println(result);
    }
}

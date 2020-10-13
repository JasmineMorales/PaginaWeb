package org.url.paginaweb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloProducto;
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

    public Producto getProductID(Integer id) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/" + id.toString() + "/";
        Producto respuesta = restTemplate.getForObject(url, Producto.class);
        return null;
    }

    public ArregloProducto getAllProducts() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        ArregloProducto response1 = restTemplate.getForObject(url1, ArregloProducto.class);
        log.info(response1.toString());
        if (response1.getCount() == 0) {
            return null;
        }
        return response1;
    }
}

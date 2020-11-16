package org.url.paginaweb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloCarrito;
import org.url.paginaweb.modelo.ArregloComentario;
import org.url.paginaweb.modelo.ArregloProducto;
import org.url.paginaweb.modelo.ArregloTipoProducto;
import org.url.paginaweb.modelo.Carrito;
import org.url.paginaweb.modelo.Comentario;
import org.url.paginaweb.modelo.DetalleCarro;
import org.url.paginaweb.modelo.DetalleCarroC;
import org.url.paginaweb.modelo.Producto;
import org.url.paginaweb.modelo.Proveedor;
import org.url.paginaweb.modelo.ProveedorArreglo;
import org.url.paginaweb.modelo.TipoProducto;

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

    public List getAllProveedores() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/proveedores/";
        ProveedorArreglo response1 = restTemplate.getForObject(url1, ProveedorArreglo.class);
        List<Proveedor> respuesta = response1.getResults();
        return respuesta;
    }

    public List getAllTipos() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/tipodeproducto/";
        ArregloTipoProducto response1 = restTemplate.getForObject(url1, ArregloTipoProducto.class);
        List<TipoProducto> respuesta = response1.getResults();
        return respuesta;
    }

    public List getAllComentarios() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/comentario/";
        ArregloComentario response1 = restTemplate.getForObject(url1, ArregloComentario.class);
        List<Comentario> respuesta = response1.getResults();
        return respuesta;
    }

    public void postProduct(Producto producto) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        Producto result = restTemplate.postForObject(url, producto, Producto.class);
        System.out.println(result);
    }

    public void putProduct(Producto producto) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/producto/";
        Producto result = restTemplate.postForObject(url, producto, Producto.class);
        System.out.println(result);
    }

    public Carrito GetCarros() {
        List<Carrito> response1 = null;
        Carrito c = null;
        //Esto cambiarlo, porque este pide por medio del id del carro, que en realidad no tenemos
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/carro/";
        ArregloCarrito response = restTemplate.getForObject(url, ArregloCarrito.class);
        if (response.getCount() == 0) {
            c = new Carrito();
            c.setUsuario(1);//cambiar esto a id de usuario
            c.setId(1);
            String url2 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/carro/";
            Carrito result = restTemplate.postForObject(url2, c, Carrito.class);
        } else {
            response1 = response.getResults();
            c = response1.get(0);
        }
        return c;
    }

    public void SetDetalleCarro(DetalleCarroC carro1) throws JsonProcessingException {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/detallecarro/";

        DetalleCarroC result = restTemplate.postForObject(url, carro1, DetalleCarroC.class);

    }
    
    
    

}

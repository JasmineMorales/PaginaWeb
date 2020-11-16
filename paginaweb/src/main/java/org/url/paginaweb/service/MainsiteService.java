/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.ArregloUsuario;
import org.url.paginaweb.modelo.ArregloVenta;
import org.url.paginaweb.modelo.Usuario;

/**
 *
 * @author marcos
 */
@Service
@Slf4j
public class MainsiteService {

    @Autowired
    private RestTemplate restTemplate;
    
        public static final String ADMIN = "ROLE_ADMIN";
    public static final String CLIENTE = "ROLE_CLIENT";
    public static final String REPARTIDOR = "ROLE_REPART";
    

    public Usuario getUsuarioID(Integer id) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/" + id.toString() + "/";
        Usuario respuesta = restTemplate.getForObject(url, Usuario.class);
        return null;

    }

    public ArregloVenta getAllUsuarios() {
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/ventas/";
        ArregloVenta response1 = restTemplate.getForObject(url1, ArregloVenta.class);
        log.info(response1.toString());
        if (response1.getCount() == 0) {
            return null;
        }
        return response1;
    }
}

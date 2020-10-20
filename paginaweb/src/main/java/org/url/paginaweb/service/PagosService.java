/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import javax.json.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.MetodoPago;
import org.url.paginaweb.modelo.PagosLista;

/**
 *
 * @author alici
 */
@Service
@Slf4j
public class PagosService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    public PagosLista getMetodoPago() {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/formadepago/";
        PagosLista respuesta = restTemplate.getForObject(url, PagosLista.class);
        return respuesta;
    }
    
    public void postMetodoPago(MetodoPago metodoPago) {
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/formadepago/";
       
        MetodoPago result = restTemplate.postForObject(url, metodoPago, MetodoPago.class);
        
        System.out.println(result);
    }
}

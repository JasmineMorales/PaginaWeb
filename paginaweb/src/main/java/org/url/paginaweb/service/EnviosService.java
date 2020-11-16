/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.Envio;  
import org.url.paginaweb.modelo.envioDos;

/**
 *
 * @author ali
 */

@Service
@Slf4j
public class EnviosService {
    @Autowired RestTemplate restTemplate;
    
    public Envio getEnvio(int id){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/estado/" + id;
        Envio respuesta = restTemplate.getForObject(url,Envio.class);
        return respuesta;
    }
    
    public Envio putEnvio(int id, Envio envio){
        String url = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/" + id; 
        String url2 ="http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/venta/{id}/";
        
        envioDos temp = restTemplate.getForObject(url, envioDos.class);
        
        
        
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("id", Integer.toString(envio.getId()));
        temp.setEstado(envio.getEstado());
        System.out.println(temp.getDireccion());
        System.out.println(temp.getCodigo());
        System.out.println(temp.getDescuento());
        System.out.println(temp.getTotal());
        
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", Integer.toString(id));
        
        HttpEntity<envioDos> httpEntity = new HttpEntity<envioDos>(temp);
        
        HttpEntity<envioDos> response = restTemplate.exchange(url2, HttpMethod.PUT, httpEntity, envioDos.class, param);
        
        System.out.println("**************************");
        System.out.println(response.getBody().getEstado());
        
        return envio;
//        restTemplate.patchForObject(url, envio, Envio.class);
        
       // System.out.println(respuesta);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.url.paginaweb.modelo.Admin;
import org.url.paginaweb.modelo.ArregloAdmin;
import org.url.paginaweb.modelo.ArregloRepartidor;
import org.url.paginaweb.modelo.ArregloUsuario;
import org.url.paginaweb.modelo.LoginUserModelo;
import org.url.paginaweb.modelo.Repartidor;
import org.url.paginaweb.modelo.Usuario;

/**
 *
 * @author marcos
 */
@Service
public class LoginPService {
    private ArrayList<Repartidor> listaRepartidor;
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Admin> listaAdmin;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public LoginUserModelo confirmar(LoginUserModelo usuario){
        
        
        String url1 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/usuarios/";
        ArregloUsuario usuarios = restTemplate.getForObject(url1, ArregloUsuario.class);
        listaUsuario = (ArrayList<Usuario>) usuarios.getResults();
        
        if(!listaUsuario.isEmpty()){
            for(Usuario u : listaUsuario){
                if(usuario.getNombre().equals(u.getCorreo()) && usuario.getPassword().equals(u.getContrasena())){
                    return new LoginUserModelo(u.getId().toString(),"ROLE_CLIENT", 1);
                }
            }
        }
        
        String url2 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/administrador/";
        ArregloAdmin admins = restTemplate.getForObject(url2, ArregloAdmin.class);
        listaAdmin = (ArrayList<Admin>) admins.getResults();
        if(!listaAdmin.isEmpty()){
            for(Admin admin : listaAdmin){
                if(admin.getCorreo().equals(usuario.getNombre()) && admin.getPassword().equals(usuario.getPassword())){
                    return new LoginUserModelo(admin.getId().toString(), "ROLE_ADMIN", 1);
                }
            }
        }
        
        String url3 = "http://ec2-54-214-157-22.us-west-2.compute.amazonaws.com/api/v1.0/repartidor/";
        ArregloRepartidor repartidores = restTemplate.getForObject(url3, ArregloRepartidor.class);
        listaRepartidor = (ArrayList<Repartidor>) repartidores.getResults();
        if(!listaRepartidor.isEmpty()){
            for(Repartidor repartidor : listaRepartidor){
                if(repartidor.getCorreo().equals(usuario.getNombre()) && repartidor.getPassword().equals(usuario.getPassword())){
                    return new LoginUserModelo(repartidor.getId().toString(), "ROLE_REPART", 1);
                }
            }
        }
        return null;
    }
    
}

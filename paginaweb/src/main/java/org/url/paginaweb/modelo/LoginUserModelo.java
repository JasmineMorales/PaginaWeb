/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import lombok.Data;

/**
 *
 * @author marcos
 */

@Data
public class LoginUserModelo {
    
    private String nombre;
    
    private String password;
    
    private String roles;
    
    public LoginUserModelo(String nombre, String passsword){
        this.nombre = nombre;
        this.password = passsword;
    }
    
    public LoginUserModelo(String nombre, String roles, int i){
        this.nombre = nombre;
        this.roles = roles;
    }
}

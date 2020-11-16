/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import lombok.Data;

/**
 *
 * @author ali
 */
@Data
public class Envio {
    private int id;
    private String estado;
    

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }  

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}

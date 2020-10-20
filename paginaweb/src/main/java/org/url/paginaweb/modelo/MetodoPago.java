/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 *
 * @author alici
 */
@Data
public class MetodoPago implements Serializable{
    private Integer id;
    
    @NotNull
    private String tipo;
    
    @NotNull
    private Boolean disponibilidad;
    
    
    public void setId(Integer id){
        this.id = id;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setDisponibilidad(Boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public Boolean getDisponibilidad(){
        return this.disponibilidad;
    }
}

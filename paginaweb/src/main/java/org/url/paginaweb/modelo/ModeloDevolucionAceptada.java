/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Ali
 */
@Data
public class ModeloDevolucionAceptada {
    private Integer venta;
    
    public Integer getVenta(){
        return this.venta;
    }
    
    public void setVenta(Integer venta){
        this.venta = venta;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class DetalleVenta implements Serializable {
    
    @NotNull
    private Integer id;
    
    @NotNull
    @Min(value = 0)
    private Integer cantidad;
    
    @NotNull
    @Min(value = 0)
    private Float subtotal;
    
    private Integer venta;
    
    private Venta ventaO;
    
    private Integer producto;

    private Producto productoO;
    
    
}

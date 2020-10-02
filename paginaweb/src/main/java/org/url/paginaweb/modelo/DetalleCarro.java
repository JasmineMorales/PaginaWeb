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
public class DetalleCarro implements Serializable{
    
    @NotNull
    private Integer idDetalleCarro;
    
    @NotNull
    @Min(value=1)
    private Integer cantidad;
    
    @NotNull
    @Min(value=0)
    private Float Subtotal;
    
    private Carrito carrito;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class Valoracion implements Serializable{
    
    @NotNull
    private Integer idValoracion;
    
    @NotNull
    private Integer Valoracion;
    
    private Integer contValoracion;
    
    private Producto producto;
    
    private Repartidor repartidor;
}

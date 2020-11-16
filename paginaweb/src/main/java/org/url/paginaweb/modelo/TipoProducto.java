/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class TipoProducto implements Serializable{
    
    private Integer id;
    
    @NotEmpty
    @Size(max = 45)
    private String categoria;
    
    private String imagen;
    
    
}

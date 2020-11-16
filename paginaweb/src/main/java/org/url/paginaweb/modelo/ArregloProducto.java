/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class ArregloProducto implements Serializable {
    
    private int count;
    
    private String next;
    
    private String previous;
    
    private List<Producto> results;
}

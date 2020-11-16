    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class Carrito implements Serializable{
    
    @NotNull
    private Integer id;
    
    private Integer usuario;
    
   // private ArrayList<DetalleCarro> detallesCarro;
    
    
}

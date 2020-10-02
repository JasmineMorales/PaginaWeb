/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class Producto implements Serializable {
    
    @NotNull
    private Integer idProducto;
    
    @NotEmpty
    @Size(max = 90)
    private String nombre;
    
    @Min(value = 0)
    private Float precio;
    
    
    private String imagen;
    
    @NotEmpty
    @Size(max = 90)
    private String descripcion;
    
    @NotNull
    private Boolean disponibilidad;
    
    private TipoProducto tipoProducto;
    
    private Proveedor proveedor;
    
    private ArrayList<Comentario> comentarios;
    
    private ArrayList<Valoracion> valoraciones;
    
    
}

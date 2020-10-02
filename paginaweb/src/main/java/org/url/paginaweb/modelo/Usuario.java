/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class Usuario implements Serializable {
    
    @NotNull
    private Integer idUsuario;
    
    @NotEmpty
    @Size(max = 30)
    private String nombre;
    
    @NotEmpty
    @Size(max = 8)
    private String telefono;
    
    @NotEmpty
    @Size(max = 30)
    private String correo;
    
    @NotEmpty
    private String password;
    
    private ArrayList<Direccion> direcciones;
    
    private ArrayList<Comentario> comentarios;
}

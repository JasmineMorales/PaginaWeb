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
public class Admin implements Serializable {
    

    private Integer id;
    
    @NotEmpty
    @Size(max = 30)
    private String correo;
    
    @NotEmpty
    @Size(max = 30)
    private String usuario;
    
    @NotEmpty
    private String password;
}

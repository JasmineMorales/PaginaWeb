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
 * @author alici
 */
@Data
public class MetodoPago implements Serializable{
    @NotNull
    private Integer id;
    
    @NotNull
    private String tipo;
    
    @NotNull
    private Boolean disponibilidad;
    
}

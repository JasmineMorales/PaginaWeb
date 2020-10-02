/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Venta implements Serializable{
    
    @NotNull
    private Integer idVenta;
    
    @NotEmpty
    @Size(max = 15)
    private String codigo;
    
    @Size(max = 45)
    private String direccion;
    
    @NotNull
    private Date fecha;
    
    
    @Min(value = 0)
    private Float descuento;
    
    private String estado;
    
    @NotNull
    @Min(value = 0)
    private Float total;
    
    private Usuario usuario;
    
    private Repartidor repartidor;
    
    private FormaPago formaPago;
    
    private ArrayList<DetalleVenta> detallesVenta;
}

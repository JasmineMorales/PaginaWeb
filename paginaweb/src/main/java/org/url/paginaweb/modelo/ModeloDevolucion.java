/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author ali
 */
@Data
public class ModeloDevolucion {
    private String correo, telefono, factura, razon;

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFactura() {
        return factura;
    }

    public String getRazon() {
        return razon;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    
}

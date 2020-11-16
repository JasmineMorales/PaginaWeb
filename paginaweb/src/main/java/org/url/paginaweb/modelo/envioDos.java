/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

/**
 *
 * @author ali
 */
public class envioDos {
    private int id;
    private String estado, codigo, direccion;
    private String descuento, total;

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescuento() {
        return descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}

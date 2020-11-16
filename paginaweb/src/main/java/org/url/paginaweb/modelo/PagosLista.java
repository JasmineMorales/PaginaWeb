/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alici
 */
public class PagosLista implements Serializable{
    private int count;
    
    private String next;
    
    private String previous;
    
    private List<MetodoPago> results;

    public List<MetodoPago> getResults() {
        return results;
    }
    
    
}

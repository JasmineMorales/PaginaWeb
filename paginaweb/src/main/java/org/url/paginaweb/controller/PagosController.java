/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alici
 */
@Controller
public class PagosController {
    @GetMapping("pagos/metodo-pago")
    public String getMetodoPago(){
        return ("pagos/metodoPago");
    };
     @GetMapping("pagos/agregar-tarjeta")
    public String getAgregarTarjeta(){
        return ("pagos/agregarTarjeta");
    };
       @GetMapping("pagos/devolucion")
    public String getDevolucion(){
        return ("pagos/devoluciones");
    }; 
          @GetMapping("pagos/devolucion-aceptada")
    public String getDevolucionAceptada(){
        return ("pagos/devolucionAceptada");
    }; 
}

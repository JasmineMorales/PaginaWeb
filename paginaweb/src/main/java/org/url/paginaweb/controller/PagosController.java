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
}

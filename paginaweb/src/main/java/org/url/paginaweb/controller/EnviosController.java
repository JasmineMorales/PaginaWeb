package org.url.paginaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alici
 */
@Controller
public class EnviosController {
    @GetMapping("/envios/estado-envio")
    public String getEnviosEstados() {
        return("/envios/envio");
    };
    @GetMapping("/envios/estado-envio-repartidor")
    public String getEnviosEstadosRepartidor() {
        return("/envios/envioRepartidor");
    };
    @GetMapping("/envios/busqueda")
    public String getBusqueda() {
        return("/envios/busqueda");
    };
}

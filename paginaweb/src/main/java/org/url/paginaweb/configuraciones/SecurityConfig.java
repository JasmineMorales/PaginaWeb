/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author marcos
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private CustomAuthenticationProvider authProvider;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
 
 /*   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                    .withUser("administrador")
                    .password("{noop}12345")
                    .roles("ADMIN")
                .and()
                    .withUser("cliente")
                    .password("{noop}12345")
                    .roles("CLIENT")
                .and()
                    .withUser("repartidor")
                    .password("{noop}12345")
                    .roles("REPART");
    }
*/    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/Productos/producto/**")
                    .hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/Productos/modificar_producto/**")
                    .hasAnyRole("ADMIN")
                .antMatchers("/Productos/agregar_producto")
                    .hasAnyRole("ADMIN")
                .antMatchers("/Productos/productos")
                    .hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/envios/estado-envio")
                    .hasAnyRole("CLIENT")
                .antMatchers("/envios/estado-envio-repartidor")
                    .hasAnyRole("ADMIN", "REPART")
                .antMatchers("/envios/busqueda")
                    .hasAnyRole("CLIENT","ADMIN","REPART")
                .antMatchers("/pagos/metodo-pago")
                    .hasAnyRole("ADMIN")
                .antMatchers("/pagos/agregar-metodo-pago")
                    .hasAnyRole("ADMIN")
                .antMatchers("/pagos/devolucion")
                    .hasAnyRole("CLIENT")
                .antMatchers("/pagos/devolucion-aceptada")
                    .hasAnyRole("ADMIN")
                .antMatchers("/administrador/registro")
                    .hasAnyRole("ADMIN")
                .antMatchers("/proveedores/registro")
                    .hasAnyRole("ADMIN")
                .antMatchers("/Compras/**")
                    .hasAnyRole("CLIENT")
                .antMatchers("/Ventas/**")
                    .hasAnyRole("Admin")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/errores/403");
                    
                     
                              
    }
}

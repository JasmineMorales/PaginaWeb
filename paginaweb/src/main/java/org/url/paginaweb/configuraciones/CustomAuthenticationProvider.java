/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.url.paginaweb.configuraciones;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.url.paginaweb.modelo.LoginUserModelo;
import org.url.paginaweb.service.LoginPService;

/**
 *
 * @author marcos
 */
@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    LoginPService loginP;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String name = authentication.getName();
       String password = authentication.getCredentials().toString();
       log.info(authentication.getAuthorities().toString());
       LoginUserModelo temp = new LoginUserModelo(name, password);
       var l = loginP.confirmar(temp);
       if(l != null){
           List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
           list.add(new SimpleGrantedAuthority(l.getRoles()));
            var usuarioAprobado = new UsernamePasswordAuthenticationToken(
                    l.getNombre(), password, list);
            return usuarioAprobado;
        }else{
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

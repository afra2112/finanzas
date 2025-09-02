package com.app.finanzas.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String rol = authentication.getAuthorities().iterator().next().getAuthority();

        if(rol.equals("USUARIO")){
            response.sendRedirect("/usuarios/index");
        } else if (rol.equals("ADMINISTRADOR")) {
            response.sendRedirect("/administradores/index");
        }else{
            response.sendRedirect("/login");
        }
    }
}

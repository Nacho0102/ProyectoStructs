/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Usuario;

/**
 *
 * @author NachoP
 */
public class FiltroEmpleados implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest peticion
                = (HttpServletRequest) request;
        HttpServletResponse respuesta
                = (HttpServletResponse) response;
        String url = peticion.getRequestURL().toString();

        if (url.contains("SeguridadEmpleados")) {

            //capturar el objeto usuario que se encuentra en la sesion
            Usuario user = (Usuario) peticion.getSession().getAttribute("JEFE");
            //preguntamos si existe el usuario para darle acceso 
            if (user == null) {

                //metemos el login por el medio
                respuesta.sendRedirect("../LoginEmpleado.jsp");
            } else {

                chain.doFilter(request, response);
            }

        } else {

            //Permitir acceso
            chain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }

}

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

public class FiltroAcceso implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest peticion = (HttpServletRequest) request;
        String usuario = (String) peticion.getSession().getAttribute("usuario");
        String url = peticion.getRequestURI();
            System.out.println("USUARIO " +usuario);
            System.out.println("URL: " + peticion.getRequestURL());
            System.out.println("URI " + peticion.getRequestURI());
            System.out.println("METODO: " + peticion.getMethod());
            System.out.println("PATHINFO: " + peticion.getPathInfo());
            System.out.println("CONTEXTPATH: " + peticion.getContextPath());        
        if (url.contains("Administracion"))
        {
            //NECESITAMOS VALIDACION
            if(usuario != null){
                //Hemos pasado el filtro
                //y existimos dentro de la aplicación
                chain.doFilter(request, response);
            }else{
                //REDIRECCIONAMOS A LA PAGINA CORRESPONDIENTE DE ERROR O LOGIN
                //NOS VAMOS A LOGGIN
                HttpServletResponse respuesta = (HttpServletResponse)response;
                respuesta.sendRedirect("../login.jsp");
            }                    
        }else{
            //PODEMOS CONTINUAR SIN PROBLEMAS...
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }
    
}

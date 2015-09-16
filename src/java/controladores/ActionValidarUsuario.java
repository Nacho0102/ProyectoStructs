/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class ActionValidarUsuario extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm formulario
                = (DynaActionForm) form;
        String usuario = formulario.get("usuario").toString();
        String password = formulario.get("password").toString();
        if (usuario.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("admin")) {
            request.getSession().setAttribute("usuario", usuario);
            return mapping.findForward("zonaadministracion");
        } else {
            request.setAttribute("mensaje", "Usuario/Password no válidos.  No tiene permisos para acceder a la aplicación.");
            return mapping.getInputForward();
        }
    }
}

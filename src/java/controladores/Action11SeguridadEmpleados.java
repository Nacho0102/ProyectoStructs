/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.modeloHospital;
import objetos.Usuario;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author NachoP
 */
public class Action11SeguridadEmpleados extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm formulario = (DynaActionForm) form;
        String usuario = formulario.get("usuario").toString();
        int password = Integer.parseInt(formulario.get("password").toString());
        modeloHospital modelo = new modeloHospital();
        Usuario user = modelo.validarEmpleado(usuario, password);

        if (user == null) {
            //No exite en la BBDD
            request.setAttribute("mensaje", "Usuario/Password no válidos");
            return mapping.findForward("loginempleados");
        } else {
            //El usuario existe , pero debemos saber su categoria o rol...
            if (user.getRol().equalsIgnoreCase("PRESIDENTE")
                    || user.getRol().equalsIgnoreCase("DIRECTOR")) {
                //Almacenamos el usuario en la sesion

                request.getSession().setAttribute("JEFE", user);

                //Tenemos acceso a la seguridad
                return mapping.findForward("accesoempleados");
            } else {
                //Existe el usuario en la BBDD pero no tiene suficiente permisos
                request.setAttribute("mensaje", "Usuario sin acceso,permisos insuficientes");
                return mapping.findForward("loginempleados");
            }
        }

    }
}

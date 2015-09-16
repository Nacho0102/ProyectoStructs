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

/**
 *
 * @author NachoP
 */
public class Action02InformacionVistaControlador extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
   

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
        
        //Capturamos el formulario
        DynaActionForm formulario = (DynaActionForm)form;
        //capturamos el dato
        String dato = formulario.getString("numero");
        int numero = Integer.parseInt(dato);
        int doble = numero * 2;
        String mensaje = "<h1 style='color:blue'>El doble de " +dato +" es..." +doble + "</h1>";
        //Request.setAtribute ("KEY",VALUE") --> enviar informacion del controlador a la vista
        request.setAttribute("doble", mensaje);
        
        return mapping.findForward("forward02");
    }
}

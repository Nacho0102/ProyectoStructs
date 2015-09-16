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
public class Action03TablaMultiplicar extends org.apache.struts.action.Action {

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
        DynaActionForm formulario = (DynaActionForm) form;
        String dato = formulario.getString("numero");
        int numero = Integer.parseInt(dato);
        String html = "<table border='1'>";
        html = "<th>Tabla de Multiplicar del " + dato +"</th>" ;
        for (int i= 0 ; i <= 10 ; i++)
        {   
            html += "<tr>";
            html += "<td> Resultado = " +numero * i + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        request.setAttribute("lista", html);
        return mapping.findForward("forward03");
    }
}

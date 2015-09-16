/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.modeloHospital;
import objetos.Empleado;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author NachoP
 */
public class Action04mostrarDepartamento extends org.apache.struts.action.Action {

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
        DynaActionForm f = (DynaActionForm)form;
        int deptno = Integer.parseInt(f.getString("deptno"));
        modeloHospital modelo = new modeloHospital();
        ArrayList<Empleado> lista = modelo.getEmpleadosDepartamento(deptno);
        request.setAttribute("empleados", lista);
        return mapping.findForward("forward07");
    }
        
    }


package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action01InformacionVistaControlador 
extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm formulario = (DynaActionForm)form;
        String jugador = formulario.getString("jugador");
        if (jugador.equalsIgnoreCase("ronaldo"))
        {
            //CORRECTO
            return mapping.findForward("correcto");    
        }else{
            //INCORRECTO
            return mapping.findForward("incorrecto");
        }
    }
}

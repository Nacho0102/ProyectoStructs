package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action02InformacionControladorVista extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm formulario = (DynaActionForm)form;
        String dato = formulario.getString("numero");
        int numero = Integer.parseInt(dato);
        int doble = numero * 2;
        String mensaje = "<h1 style='color:blue'>El doble de "
                + dato + " es... " + doble + "</h1>";
        //REQUEST.SETATTRIBUTE("KEY", VALUE);
        request.setAttribute("doble", mensaje);
        
        return mapping.findForward("forward02");
    }
}

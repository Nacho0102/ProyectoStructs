package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action10EmpleadosRadio extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm f = (DynaActionForm)form;
        String seleccionado = f.getString("apellido");
        request.setAttribute("mensaje", "<h2 style='color:fuchsia'>Ha seleccionado "
                + " el elemento: " + seleccionado + "</h2>");
        return mapping.findForward("forward10");
    }
}

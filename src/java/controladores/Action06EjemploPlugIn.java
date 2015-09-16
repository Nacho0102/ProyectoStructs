package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action06EjemploPlugIn extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm f = (DynaActionForm)form;
        String dato = f.getString("equipo");
        int equipo = Integer.parseInt(dato);
        String html = "";
        if (equipo == 1)
        {
            html = "<h2 style='color:blue'>Sabes un montón de fútbol</h2>";
        }else{
            html = "<h2 style='color:red'>No tienes ni idea....</h2>";
        }
        request.setAttribute("mensaje", html);
        return mapping.findForward("forward06");
    }
}

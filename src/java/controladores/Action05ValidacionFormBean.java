package controladores;

import formularios.Form05ValidacionFormBean;
import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

public class Action05ValidacionFormBean extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MessageResources recursos =
                getResources(request);
        String mensaje = recursos.getMessage("mensaje.action");
        
        Form05ValidacionFormBean f = 
                (Form05ValidacionFormBean)form;
        String nombre = f.getNombre();
        int edad = f.getEdad();
        mensaje = 
                MessageFormat.format(mensaje, 
                        new Object[] { nombre, edad });        
        request.setAttribute("mensaje", mensaje);
        return mapping.getInputForward();
    }
}

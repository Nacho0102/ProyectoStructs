package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.modeloHospital;
import objetos.Departamento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action09InsertarDepartamento extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm f = (DynaActionForm)form;
        int deptno = Integer.parseInt(f.getString("numero"));
        String nombre = f.getString("nombre");
        String localidad = f.getString("localidad");
        modeloHospital modelo = new modeloHospital();
        modelo.insertarDepartamento(deptno, nombre, localidad);
        request.setAttribute("mensaje", "<h3 style='color:blue'>Departamento insertado correctamente</h3>");
        
        ArrayList<Departamento> lista = modelo.getDepartamentos();
        request.setAttribute("departamentos", lista);
        
        return mapping.findForward("forward09");
    }
}

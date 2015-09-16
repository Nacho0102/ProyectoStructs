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

public class Action07Departamentos extends org.apache.struts.action.Action {

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

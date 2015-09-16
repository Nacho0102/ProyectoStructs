package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.modeloHospital;
import objetos.Empleado;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class Action04BuscarEmpleado extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm formulario = (DynaActionForm)form;
        String dato = formulario.getString("empleadono");
        int empno = Integer.parseInt(dato);
        modeloHospital modelo = new modeloHospital();
        Empleado emp = modelo.buscarEmpleado(empno);
        String html = "";
        if (emp == null)
        {
            html = "<h2 style='color:red'>No existe ningún empleado con ID: "
                    + dato + "</h2>";
        }else{
            html = "<dl>";
            html += "<dt><b>" + emp.getApellido() + "</b></dt>";
            html += "<dd>Oficio: " + emp.getOficio() + "</dd>";
            html += "<dd>Salario: " + emp.getSalario() + "</dd>";
            html += "</dl>";
        }
        request.setAttribute("empleado", html);
        return mapping.findForward("forward04");
    }
}

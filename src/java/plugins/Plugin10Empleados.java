package plugins;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import modelos.modeloHospital;
import objetos.Empleado;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class PlugIn10Empleados implements PlugIn
{
    @Override
    public void destroy() {}

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException 
    {
        try
        {
            modeloHospital modelo = new modeloHospital();
            ArrayList<Empleado> lista = modelo.getEmpleados();
            servlet.getServletContext().setAttribute("empleados", lista);
        }catch (SQLException ex)
        {
            System.out.println("Excepción: " + ex);
        }
    }
    
}

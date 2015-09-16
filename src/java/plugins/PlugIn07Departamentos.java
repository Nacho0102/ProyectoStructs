package plugins;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import modelos.modeloHospital;
import objetos.Departamento;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class PlugIn07Departamentos implements PlugIn
{

    @Override
    public void destroy() {}

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) 
            throws ServletException {
        modeloHospital modelo = new modeloHospital();
        ArrayList<Departamento> lista = null;
        try {
            lista = modelo.getDepartamentos();
        }catch (SQLException ex) {
            System.out.println("Excepcion: " + ex);
        }
        servlet.getServletContext().setAttribute("departamentos", lista);
    }
}

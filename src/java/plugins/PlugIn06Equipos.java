package plugins;

import java.util.HashMap;
import java.util.Hashtable;
import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class PlugIn06Equipos implements PlugIn 
{

    @Override
    public void destroy() {}

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        HashMap<Integer, String>
                equipos = new HashMap();
        equipos.put(1, "REAL MADRID");
        equipos.put(2, "BARCELONA");
        equipos.put(3, "ATLETICO DE MADRID");
        equipos.put(4, "VALENCIA");
        equipos.put(5, "RAYO");
        servlet.getServletContext().setAttribute("equipos", equipos);
    }
    
}

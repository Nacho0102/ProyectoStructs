package formularios;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class Form05ValidacionFormBean 
extends org.apache.struts.action.ActionForm {
    
    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Form05ValidacionFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (nombre.isEmpty())
        {
            errors.add("nombre", new ActionMessage("form.nombre.error"));
        }
        if (edad < 18)
        {
            errors.add("edad", new ActionMessage("form.edad.error"
                    , new Object[]{ edad } ));
        }
        return errors;
    }
}

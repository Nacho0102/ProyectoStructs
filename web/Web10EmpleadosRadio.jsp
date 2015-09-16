<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejemplo de Radios con Empleados</h1>
        <html:form action="/Action10EmpleadosRadio">
            <ul>
                <logic:iterate name="empleados" id="emp">
                    <li>
                        <html:radio property="apellido"
                                    value='${emp.apellido}'/>
                        <bean:write name="emp" property="apellido"/>
                    </li>
                </logic:iterate>
            </ul>
            <br/>
            <button type="submit">Mostrar seleccionado</button>
        </html:form>
        <br/>
        <logic:present name="mensaje">
            <bean:write name="mensaje" filter="false"/>
        </logic:present>
    </body>
</html>

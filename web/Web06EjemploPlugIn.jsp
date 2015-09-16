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
        <h1>Ejemplo PlugIn</h1>
        <html:form action="/Action06EjemploPlugIn">
            Ganador de la liga 2016:
            <html:select property="equipo">
                <html:options collection="equipos"
                              property="key"
                              labelProperty="value"/>
            </html:select>
            
            
            <button type="submit">Mostrar respuesta</button>
        </html:form>
        <hr/>
        <logic:present name="mensaje">
            <bean:write name="mensaje"
                        filter="false"/>
        </logic:present>
    </body>
</html>

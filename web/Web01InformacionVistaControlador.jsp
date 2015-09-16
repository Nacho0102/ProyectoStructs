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
        <h1>Información Vista Contralador</h1>
        <html:form action="/Action01InformacionVistaControlador">
            Mejor jugador del mundo:
            <html:text property="jugador"/>
            <html:submit value="Mostrar respuesta"/>
        </html:form>        
    </body>
</html>











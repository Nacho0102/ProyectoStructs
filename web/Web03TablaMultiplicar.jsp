<%-- 
    Document   : Web03TablaMultiplicar
    Created on : 28-jul-2015, 12:39:55
    Author     : NachoP
--%>

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
        <h1>Tabla de Multiplicar</h1>
        <html:form action="/Action03TablaMultiplicar">
            Introduzca Número:
            <html:text property="numero"/>
            <button type="submit">Mostrar Tabla Multiplicar</button>
        </html:form>
                   
    </body>
</html>

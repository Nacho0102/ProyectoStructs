<%-- 
    Document   : LoginEmpleado
    Created on : 01-sep-2015, 10:00:50
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
        <h1>Acceso de empleados</h1>
        <html:form action="/Action11SeguridadEmpleados">
            <div>
                <label>Usuario</label>
                <html:text property="usuario"/>
            </div>
            <div>
                <label>Password</label>
                <html:text property="password"/>
            </div>
            <html:submit value="Acceso a administración"/>
        </html:form>
        <logic:present name="mensaje">
            <h3 style='color:red'>
                <bean:write name="mensaje"/>
            </h3>
        </logic:present>

    </body>
</html>

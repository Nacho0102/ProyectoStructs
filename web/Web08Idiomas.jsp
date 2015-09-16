<%@page import="org.apache.struts.Globals"%>
<%@page import="java.util.Locale"%>
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
        <%
        if (request.getParameter("idioma") != null)
        {
            String idioma = request.getParameter("idioma");
            Locale lengua = new Locale(idioma);
            session.setAttribute(Globals.LOCALE_KEY, lengua);
        }
        %>
        <h1>
            <bean:message key="idioma.saludo"/>
        </h1>
        <br/>
        <img src='<bean:message key="idioma.imagen"/>'
             style='width:200px;height:200px'/>
        <ul>
            <li>
                <html:link href="Web08Idiomas.jsp?idioma=en">
                    <bean:message key="idioma.ingles"/>
                </html:link>
            </li>
            <li>
                <html:link href="Web08Idiomas.jsp?idioma=es">
                    <bean:message key="idioma.español"/>
                </html:link>
            </li>
        </ul>
    </body>
</html>

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
        <h1>Validacion de formularios FORM BEAN</h1>
        <html:form action="/Action05ValidacionFormBean">
            Nombre: 
            <html:text property="nombre"/>
            <span style="color:red">
                <html:errors property="nombre"/>
            </span>
            <br/>
            Edad:
            <html:text property="edad"/>
            <span style="color:red">
                <html:errors property="edad"/>
            </span>
            <br/>
            <button type="submit">Enviar datos</button>
        </html:form>
        <hr/>
        <logic:present name="mensaje">
            <h3 style="color:blue">
                <bean:write name="mensaje"/>
            </h3>
        </logic:present>
    </body>
</html>

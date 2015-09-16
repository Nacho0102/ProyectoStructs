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
        <h1>Insertar departamentos</h1>
        <html:form action="/Action09InsertarDepartamento">
            Numero:
            <html:text property="numero"/>
            <br/>
            Nombre:
            <html:text property="nombre"/>
            <br/>
            Localidad:
            <html:text property="localidad"/>
            <br/>
            <button type='submit'>Insertar departamento</button>
        </html:form>
        <hr/>
        <logic:present name="mensaje">
            <bean:write name="mensaje" filter="false"/>
        </logic:present>
        <table border='1'>
            <tr>
                <th>NUMERO</th>
                <th>NOMBRE</th>
                <th>LOCALIDAD</th>
            </tr>
        <logic:iterate name="departamentos" id="d">
            <tr>
                <td>
                    <bean:write name="d" property="numero"/>
                </td>
                <td>
                    <bean:write name="d" property="nombre"/>
                </td>
                <td>
                    <bean:write name="d" property="localidad"/>
                </td>
            </tr>
        </logic:iterate>
        </table>
    </body>
</html>

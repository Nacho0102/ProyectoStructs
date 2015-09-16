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
        <h1>Departamentos con PlugIn</h1>
        <html:form action="/Action07Departamentos">
            Departamentos:
            <html:select property="deptno">
                <html:options  collection="departamentos"
                               property="numero"
                               labelProperty="nombre"/>
            </html:select>
            <button type="submit">Buscar empleados</button>
        </html:form>
        <hr/>
        <logic:present name="empleados">
            <table border='1'>
                <tr>
                    <th>APELLIDO</th>
                    <th>OFICIO</th>
                    <th>SALARIO</th>
                </tr>
            <logic:iterate name="empleados" id="emp">
                <tr>
                    <td>
                        <bean:write name="emp" property="apellido"/>
                    </td>
                    <td>
                        <bean:write name="emp" property="oficio"/>
                    </td>
                    <td>
                        <bean:write name="emp" property="salario"/>
                    </td>
                </tr>
            </logic:iterate>
            </table>
        </logic:present>
    </body>
</html>

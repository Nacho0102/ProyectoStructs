<%-- 
    Document   : Subordinados
    Created on : 01-sep-2015, 9:59:52
    Author     : NachoP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="modelo" class="modelos.modeloHospital"
             scope="request"/>

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
        <h1>Seguridad de empleados</h1>
        
                <h3 style="color:blue">Bienvenido a la administración, 
            <c:out value="${sessionScope.JEFE.apellido}"/>
        </h3>
            <c:set value="${sessionScope.JEFE.idempleado}" var="empno"/>
            <c:set value="${sessionScope.JEFE.rol}" var="rol"/>
            <c:set var="listaempleados" value="${modelo.getSubordinados(empno)}"/>
            <ul>
                <c:forEach items="${listaempleados}" var="fila">
                    <li>
                        <c:out value="${fila.apellido}"/>
                        <c:if test='${rol == "PRESIDENTE"}'>
                            <a href="Action11EliminarSubordinados.do?idempleado=${fila.empno}">
                                Eliminar empleado
                            </a>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>

        
        
        <html:link forward="inicioempleados"> Volver al inicio </html:link>
        <br>
        <html:link action="/Action11CerrarSesion"> Cerrar Sesion</html:link>
        
    </body>
</html>

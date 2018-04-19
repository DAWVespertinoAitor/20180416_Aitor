<%-- 
    Document   : index
    Created on : 16-oct-2017, 16:59:06
    Author     : Jesus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.albarregas.beans.Calculator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <c:set var="calcu" value="${requestScope.calculadora}"/>
        <div class="columnasCentradas">
            
            <h1><c:out value="${calculadora.error}"/></h1>
            <p><a href="<%= request.getContextPath()%>">Volver</a></p>
        </div>
    </body>
</html>
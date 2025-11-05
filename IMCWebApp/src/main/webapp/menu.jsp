<%-- 
    Document   : menu
    Created on : Nov 4, 2025, 9:28:02 PM
    Author     : jos9
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.mycompany.imcwebapp.model.Usuario" %>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
    if (u == null) { response.sendRedirect("index.jsp"); return; }
%>
<html>
<head><title>Menú IMC</title></head>
<body>
<h2>Bienvenido, <%= u.getNombreCompleto() %>!</h2>
<a href="calcular.jsp">Calcular IMC</a> |
<a href="historial.jsp">Ver historial</a> |
<a href="index.jsp">Cerrar sesión</a>
</body>
</html>

<%-- 
    Document   : calcular
    Created on : Nov 4, 2025, 9:28:30 PM
    Author     : jos9
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Calcular IMC</title></head>
<body>
<h2>Calcular IMC</h2>
<form action="calcular" method="post">
    Masa (kg): <input type="number" step="0.1" name="masa"><br>
    <input type="submit" value="Calcular">
</form>
<% if (request.getAttribute("resultado") != null) { %>
    <h3>Tu IMC: <%= request.getAttribute("resultado") %></h3>
    <p><b><%= request.getAttribute("interpretacion") %></b></p>
<% } %>
<font color="red">${error}</font>
</body>
</html>

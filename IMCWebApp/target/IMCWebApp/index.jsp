<%-- 
    Document   : index
    Created on : Nov 4, 2025, 10:03:42 PM
    Author     : jos9
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Login IMC</title></head>
<body>
<h2>Iniciar Sesión</h2>
<form action="login" method="post">
    Usuario: <input type="text" name="usuario"><br>
    Contraseña: <input type="password" name="contrasena"><br>
    <input type="submit" value="Ingresar">
</form>
<p><a href="registro.jsp">Registrarse</a></p>
<font color="red">${error}</font>
</body>
</html>
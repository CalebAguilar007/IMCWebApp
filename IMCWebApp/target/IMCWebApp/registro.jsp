<%-- 
    Document   : registro
    Created on : Nov 4, 2025, 9:03:14 PM
    Author     : jos9
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Registro</title></head>
<body>
<h2>Registro de Usuario</h2>
<form action="registro" method="post">
    Nombre completo: <input type="text" name="nombre"><br>
    Edad: <input type="number" name="edad"><br>
    Sexo: <input type="text" name="sexo"><br>
    Estatura (m): <input type="text" name="estatura"><br>
    Usuario: <input type="text" name="usuario"><br>
    Contraseña: <input type="password" name="contrasena"><br>
    <input type="submit" value="Registrar">
</form>
<font color="red">${error}</font>
<font color="green">${mensaje}</font>
</body>
</html>


<%-- 
    Document   : historial
    Created on : Nov 4, 2025, 9:29:02 PM
    Author     : jos9
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Historial IMC</title>
<script>
async function cargarHistorial() {
    const res = await fetch("api/historial");
    if (!res.ok) {
        document.body.innerHTML = "Error al cargar historial.";
        return;
    }
    const datos = await res.json();
    let tabla = "<table border='1'><tr><th>Masa</th><th>IMC</th><th>Interpretación</th><th>Fecha</th></tr>";
    datos.forEach(d => {
        tabla += `<tr><td>${d.masa}</td><td>${d.resultadoIMC}</td><td>${d.interpretacion}</td><td>${d.fechaCalculo}</td></tr>`;
    });
    tabla += "</table>";
    document.getElementById("contenido").innerHTML = tabla;
}
window.onload = cargarHistorial;
</script>
</head>
<body>
<h2>Historial de Cálculos IMC</h2>
<div id="contenido">Cargando...</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String usuario = (String) session.getAttribute("usuario");
if (usuario == null) {
	response.sendRedirect("../login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Crear capacitación</title>
<link rel="stylesheet" href="../assets/css/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="container mt-3">
		<nav class="navbar navbar-expand-sm">
			<div class="container-fluid">
				<a class="navbar-brand" href="./index.jsp">Asesorías en Prevención de Riesgos SPA</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="../index.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="../contacto/formularioContacto.jsp">Contacto</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Capacitación
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="../capacitacion/crearCapacitacion.jsp">Crear capacitación</a>
                            <a class="dropdown-item" href="../capacitacion/listarCapacitaciones.jsp">Listar capacitaciones</a>
                        </div>
                    </li>
					<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Usuario
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="../usuarios/crearUsuario.jsp">Crear usuario</a>
                            <a class="dropdown-item" href="../usuarios/listarUsuarios.jsp">Listar usuarios</a>
                        </div>
					<li class="nav-item"><a class="nav-link" href="../logout.jsp">Cerrar sesión</a></li>
				</ul>
			</div>
		</nav>
		<h1>Crear capacitación</h1>

		<form id="crearCapacitacionForm" action="../ResumenCapacitacion" method="post">
			<div class="form-group">
				<label for="nombreCurso">Nombre del curso:</label>
				<input type="text" class="form-control" id="nombreCurso" name="nombreCurso" required>
			</div>

			<div class="form-group">
				<label for="detalle">Detalle:</label>
				<input type="text" class="form-control" id="detalle" name="detalle" required>
			</div>

			<button type="submit" class="btn btn-primary">Crear</button>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#crearCapacitacionForm").submit(function(event) {
				var nombreCurso = $("#nombreCurso").val();
				var detalle = $("#detalle").val();
				
				if (nombreCurso.trim().length === 0) {
					alert("Por favor ingresa el nombre del curso.");
					event.preventDefault();
				}
				
				if (detalle.trim().length === 0) {
					alert("Por favor ingresa el detalle de la capacitación.");
					event.preventDefault();
				}
			});
		});
	</script>

</body>
</html>

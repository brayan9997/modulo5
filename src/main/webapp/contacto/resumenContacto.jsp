<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String usuario = (String) session.getAttribute("usuario");
if (usuario == null) {
	response.sendRedirect("./login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Resumen contacto</title>
<link rel="stylesheet" href="./assets/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container mt-3">
	<nav class="navbar navbar-expand-sm">
			<div class="container-fluid">
				<a class="navbar-brand" href="./index.jsp">Asesorías en
					Prevención de Riesgos SPA</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="./index.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./contacto/formularioContacto.jsp">Contacto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./capacitacion/crearCapacitacion.jsp">Crear capacitación</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="./usuarios/crearUsuario.jsp">Crear usuario</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="./logout.jsp">Cerrar sesión</a>
					</li>
				</ul>
			</div>
		</nav>
		<h1>Resumen contacto</h1>

		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Datos del Empleado</h5>
				<p class="card-text">
					<strong>Nombre:</strong>
					<%=request.getParameter("nombre")%></p>
				<p class="card-text">
					<strong>Apellido:</strong>
					<%=request.getParameter("apellido")%></p>
				<p class="card-text">
					<strong>Correo Electrónico:</strong>
					<%=request.getParameter("correo")%></p>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

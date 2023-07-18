<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Contacto</title>
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
					<li class="nav-item"><a class="nav-link" href="../usuarios/crearUsuario.jsp">Crear usuario</a></li>
					<li class="nav-item"><a class="nav-link" href="../logout.jsp">Cerrar sesión</a></li>
				</ul>
			</div>
		</nav>
		<h1>Contacto</h1>

		<form id="formularioContacto" action="../ResumenContacto" method="post">
			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<input type="text" class="form-control" id="nombre" name="nombre" required>
			</div>

			<div class="form-group">
				<label for="apellido">Apellido:</label>
				<input type="text" class="form-control" id="apellido" name="apellido" required>
			</div>

			<div class="form-group">
				<label for="correo">Correo Electrónico:</label>
				<input type="email" class="form-control" id="correo" name="correo" required>
			</div>

			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#formularioContacto").submit(function(event) {
				var nombre = $("#nombre").val();
				var apellido = $("#apellido").val();
				var correo = $("#correo").val();
				
				if (nombre.trim().length === 0) {
					alert("Por favor ingresa tu nombre.");
					event.preventDefault();
				}
				
				if (apellido.trim().length === 0) {
					alert("Por favor ingresa tu apellido.");
					event.preventDefault();
				}
				
				if (correo.trim().length === 0) {
					alert("Por favor ingresa tu correo electrónico.");
					event.preventDefault();
				} else if (!validateEmail(correo)) {
					alert("Por favor ingresa un correo electrónico válido.");
					event.preventDefault();
				}
			});
			
			function validateEmail(email) {
				var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
				return re.test(email);
			}
		});
	</script>

</body>
</html>

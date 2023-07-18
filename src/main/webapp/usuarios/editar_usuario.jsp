<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Usuario"%>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Administrativo"%>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Cliente"%>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Profesional"%>
<%@ page import="java.util.Map"%>

<html>
<head>
<title>Editar Usuario</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Editar Usuario</h1>
		<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		String tipoUsuario = usuario.getTipo().toString();
		%>
		<form action="act-usuario" method="POST">
			<input type="hidden" name="id" value="<%=usuario.getId()%>">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" name="nombre"
					value="<%=usuario.getNombre()%>">
			</div>
			<div class="form-group">
				<label for="tipo">Tipo de usuario:</label> <input type="text"
					class="form-control" name="tipo" value="<%=tipoUsuario%>"
					readonly>
			</div>
			<%
			switch (usuario.getTipo()) {
			case ADMINISTRATIVO:
				Administrativo administrativo = (Administrativo) usuario;
			%>
			<div class="form-group">
				<label for="area">Área:</label> <input type="text"
					class="form-control" name="area"
					value="<%=administrativo.getArea()%>">
			</div>
			<div class="form-group">
				<label for="experienciaPrevia">Experiencia previa:</label> <input
					type="text" class="form-control" name="experienciaPrevia"
					value="<%=administrativo.getExperienciaPrevia()%>">
			</div>
			<%
			break;
			case CLIENTE:
				Cliente cliente = (Cliente) usuario;
			%>
			<div class="form-group">
				<label for="rut">RUT:</label> 
				<input type="text" class="form-control" name="rut" value="<%=cliente.getRut()%>">

			</div>
			<%
			break;
			case PROFESIONAL:
				Profesional profesional = (Profesional) usuario;
			%>
			<div class="form-group">
				<label for="titulo">Titulo:</label> <input type="text"
					class="form-control" name="titulo"
					value="<%=profesional.getTitulo()%>">
			</div>
			<%
			break;
			}
			%>
		</form>
	</div>

	<!-- Agregar los scripts de JavaScript de Bootstrap al final del documento -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
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
    <title>Crear usuario</title>
    <link rel="stylesheet" href="../assets/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                        <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Usuario
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="../usuarios/crearUsuario.jsp">Crear usuario</a>
                            <a class="dropdown-item" href="../usuarios/listarUsuarios.jsp">Listar usuarios</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="../logout.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </nav>
        <h1>Crear Usuario</h1>
        <form id="crearUsuarioForm" action="../ResumenUsuarios" method="post">
    <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" class="form-control" id="nombre" name="nombreUsuario" required>
    </div>
    <div class="form-group">
        <label for="tipo">Tipo:</label>
        <select class="form-control" id="tipo" name="tipoUsuario" required>
            <option value="Cliente">Cliente</option>
            <option value="Administrativo">Administrativo</option>
            <option value="Profesional">Profesional</option>
        </select>
    </div>
    
    <!-- Campos adicionales Cliente -->
    <div id="camposCliente" class="campos-adicionales" style="display: none;">
        <div class="form-group">
            <label for="rut">RUT:</label>
            <input type="text" class="form-control" id="rut" name="rut">
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" class="form-control" id="telefono" name="telefono">
        </div>
        <div class="form-group">
            <label for="afp">AFP:</label>
            <input type="text" class="form-control" id="afp" name="afp">
        </div>
        <div class="form-group">
            <label for="sistemaSalud">Sistema de Salud:</label>
            <input type="text" class="form-control" id="sistemaSalud" name="sistemaSalud">
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" class="form-control" id="direccion" name="direccion">
        </div>
        <div class="form-group">
            <label for="comuna">Comuna:</label>
            <input type="text" class="form-control" id="comuna" name="comuna">
        </div>
        <div class="form-group">
            <label for="edad">Edad:</label>
            <input type="number" class="form-control" id="edad" name="edad">
        </div>
    </div>
    
    <!-- Campos adicionales Administrativo -->
    <div id="camposAdministrativo" class="campos-adicionales" style="display: none;">
        <div class="form-group">
            <label for="area">Área:</label>
            <input type="text" class="form-control" id="area" name="area">
        </div>
        <div class="form-group">
            <label for="experiencia">Experiencia Previa:</label>
            <textarea class="form-control" id="experiencia" name="experiencia"></textarea>
        </div>
    </div>
    
    <!-- Campos adicionales Profesional -->
    <div id="camposProfesional" class="campos-adicionales" style="display: none;">
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" class="form-control" id="titulo" name="titulo">
        </div>
        <div class="form-group">
            <label for="fechaIngreso">Fecha de Ingreso:</label>
            <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso">
        </div>
    </div>
    
    <button type="submit" class="btn btn-primary">Crear usuario</button>
</form>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../assets/js/scripts.js"></script>
</body>
</html>

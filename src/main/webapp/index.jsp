<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/styles.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>

</head>
<body>
 <div class="container mt-3">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Asesorías en Prevención de Riesgos SPA</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="./contacto/formularioContacto.jsp">Contacto</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Capacitación
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="./capacitacion/crearCapacitacion.jsp">Crear capacitación</a>
                            <a class="dropdown-item" href="./capacitacion/listarCapacitaciones.jsp">Listar capacitaciones</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Usuario
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="./usuarios/crearUsuario.jsp">Crear usuario</a>
                            <a class="dropdown-item" href="./usuarios/listarUsuarios.jsp">Listar usuarios</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="logout.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </nav>
    </div>

	<div class="container mt-3">
		<div class="mt-4 p-5 border rounded">
			<h1>Bienvenidos</h1>
			<p>Ofrecemos servicios especializados en prevención de riesgos
				laborales, para ayudar a tu empresa a mantener un entorno seguro y
				cumplir con las regulaciones vigentes.</p>
			<p>Contamos con un equipo de profesionales altamente capacitados
				que brindan asesoramiento experto y soluciones adaptadas a tus
				necesidades específicas.</p>
		</div>
	</div>

	<div class="container mt-3">
		<footer class="border rounded">© 2023 - APR SPA</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

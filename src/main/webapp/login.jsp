<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Login</title>

</head>
<body class="login">
	<div class="card-wrapper mt-3">
		<div class="card text-center">
			<div class="card-header">Iniciar sesión</div>
			<div class="card-body">
				<form action="Login" method="post">
					<div class="form-group">
						<label for="inputUsuario">Usuario</label> <input type="text"
							class="form-control" id="inputUsuario" name="usuario"
							placeholder="Ingresa tu usuario">
					</div>
					<div class="form-group">
						<label for="inputPassword">Contraseña</label> <input
							type="password" class="form-control" id="inputPassword"
							name="contrasena" placeholder="Ingresa tu contraseña">
					</div>
					<button type="submit" class="btn btn-primary">Iniciar
						sesión</button>
				</form>
			</div>
			<div class="card-footer text-muted">
				¿No tienes una cuenta? <a href="#">Regístrate</a>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
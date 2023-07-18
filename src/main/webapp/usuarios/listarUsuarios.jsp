<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
String usuario = (String) session.getAttribute("usuario");
if (usuario == null) {
    response.sendRedirect("../login.jsp");
}
%>
<%@ page import="java.util.List" %>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Usuario" %>
<%@ page import="cl.awakelab.empresaasesorias.implementacion.UsuarioImpl" %>
<!DOCTYPE html>
<html>
<head>
<title>Listado de usuarios</title>
<link rel="stylesheet" href="../assets/css/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

   
        <h1>Usuarios</h1>

        <div class="table-responsive">
            <table class="table mt-3">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    UsuarioImpl usuarioImpl = new UsuarioImpl();
                    List<Usuario> usuarios = usuarioImpl.obtenerUsuarios();
                    if (usuarios != null && !usuarios.isEmpty()) {
                        for (Usuario usuarioLista : usuarios) {
                    %>
                    <tr>
                        <td><%= usuarioLista.getNombre() %></td>
                        <td><%= usuarioLista.getTipo() %></td>
                        <td>
                            <a href="../EditarUsuario?id=<%= usuarioLista.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="../EliminarUsuario?id=<%= usuarioLista.getId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="3">No hay usuarios a mostrar</td>
                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

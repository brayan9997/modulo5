<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
String usuario = (String) session.getAttribute("usuario");
if (usuario == null) {
	response.sendRedirect("../login.jsp");
}
%>
<%@ page import="cl.awakelab.empresaasesorias.modelo.Capacitacion" %>
<%@ page import="java.util.List" %>
<%@ page import="cl.awakelab.empresaasesorias.implementacion.CapacitacionImpl" %>
<html>
<head>
    <title>Listar Capacitaciones</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Listado de Capacitaciones</h1>
        <table class="table table-striped mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Detalle</th>
                    
                </tr>
            </thead>
            <tbody>
                <% 
                CapacitacionImpl capacitacionImpl = new CapacitacionImpl();
        		List<Capacitacion> capacitaciones = capacitacionImpl.obtenerCapacitaciones();
                for (Capacitacion capacitacion : capacitaciones) {
                %>
                    <tr>
                        <td><%= capacitacion.getId() %></td>
                        <td><%= capacitacion.getNombre() %></td>
                        <td><%= capacitacion.getDetalle() %></td>
                        <td>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>


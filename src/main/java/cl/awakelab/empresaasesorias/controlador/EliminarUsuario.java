package cl.awakelab.empresaasesorias.controlador;

import java.io.IOException;

import cl.awakelab.empresaasesorias.implementacion.UsuarioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioImpl usuarioImpl= new UsuarioImpl();
        usuarioImpl.eliminarUsuario(id);

        response.sendRedirect("ListarUsuarios");
    }
}


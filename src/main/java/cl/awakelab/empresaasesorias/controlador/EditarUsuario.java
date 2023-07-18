package cl.awakelab.empresaasesorias.controlador;

import java.io.IOException;

import cl.awakelab.empresaasesorias.implementacion.UsuarioImpl;
import cl.awakelab.empresaasesorias.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioImpl usuarioImpl = new UsuarioImpl();
        Usuario usuario = usuarioImpl.obtenerUsuarioporId(id);

        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/usuarios/editar_usuario.jsp").forward(request, response);
    }
}


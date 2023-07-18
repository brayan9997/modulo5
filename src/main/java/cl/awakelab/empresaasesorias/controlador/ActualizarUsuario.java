package cl.awakelab.empresaasesorias.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import cl.awakelab.empresaasesorias.implementacion.UsuarioImpl;
import cl.awakelab.empresaasesorias.modelo.Administrativo;
import cl.awakelab.empresaasesorias.modelo.Usuario;
import cl.awakelab.empresaasesorias.modelo.Usuario.TipoUsuario;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/ActualizarUsuario")
public class ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tipoUsuario = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
		
        Usuario usuario = null;
        
		switch (tipoUsuario) {
		case "ADMINISTRATIVO":
			String area = request.getParameter("area");
			String experiencia = request.getParameter("experiencia");
			Administrativo administrativo = new Administrativo();
			administrativo.setNombre(nombre);
			administrativo.setArea(area);
			administrativo.setExperienciaPrevia(experiencia);
			administrativo.setTipo(TipoUsuario.ADMINISTRATIVO);
			usuario = administrativo;
			break;
		}
	

		UsuarioImpl usuarioImpl = new UsuarioImpl();
		usuarioImpl.actualizarUsuario(usuario);

        response.sendRedirect("/ListarUsuarios");
	}

}

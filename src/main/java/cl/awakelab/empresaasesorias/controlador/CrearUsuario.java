package cl.awakelab.empresaasesorias.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.empresaasesorias.conexion.UsuarioDAO;
import cl.awakelab.empresaasesorias.implementacion.CapacitacionImpl;
import cl.awakelab.empresaasesorias.implementacion.UsuarioImpl;
import cl.awakelab.empresaasesorias.modelo.Administrativo;
import cl.awakelab.empresaasesorias.modelo.Capacitacion;
import cl.awakelab.empresaasesorias.modelo.Cliente;
import cl.awakelab.empresaasesorias.modelo.Profesional;
import cl.awakelab.empresaasesorias.modelo.Usuario;
import cl.awakelab.empresaasesorias.modelo.Usuario.TipoUsuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/ResumenUsuarios")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuario() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreUsuario = request.getParameter("nombreUsuario");
		String tipoUsuario = request.getParameter("tipoUsuario");

		Usuario usuario = null;
		switch (tipoUsuario) {
		case "Administrativo":
			String area = request.getParameter("area");
			String experiencia = request.getParameter("experiencia");
			Administrativo administrativo = new Administrativo();
			administrativo.setNombre(nombreUsuario);
			administrativo.setArea(area);
			administrativo.setExperienciaPrevia(experiencia);
			administrativo.setTipo(TipoUsuario.ADMINISTRATIVO);
			usuario = administrativo;
			break;
		case "Cliente":
			String rut = request.getParameter("rut");
			String telefono = request.getParameter("telefono");
			String afp = request.getParameter("afp");
			String sistemaSalud = request.getParameter("sistemaSalud");
			String direccion = request.getParameter("direccion");
			String comuna = request.getParameter("comuna");
			int edad = Integer.parseInt(request.getParameter("edad"));
			Cliente cliente = new Cliente();
			cliente.setNombre(nombreUsuario);
			cliente.setRut(rut);
			cliente.setTelefono(telefono);
			cliente.setAfp(afp);
			cliente.setSistemaSalud(sistemaSalud);
			cliente.setDireccion(direccion);
			cliente.setComuna(comuna);
			cliente.setEdad(edad);
			cliente.setTipo(TipoUsuario.CLIENTE);
			usuario = cliente;
			break;
		case "Profesional":
			String titulo = request.getParameter("titulo");
			String fechaIngreso = request.getParameter("fechaIngreso");
			Profesional profesional = new Profesional();
			profesional.setNombre(nombreUsuario);
			profesional.setTitulo(titulo);
			profesional.setFechaIngreso(fechaIngreso);
			profesional.setTipo(TipoUsuario.PROFESIONAL);
			usuario = profesional;
			break;
		}
		
		UsuarioImpl usuarioImpl = new UsuarioImpl();
		usuarioImpl.agregarUsuario(usuario);
		
		request.getRequestDispatcher("/usuarios/listarUsuarios.jsp").forward(request, response);
	}

}

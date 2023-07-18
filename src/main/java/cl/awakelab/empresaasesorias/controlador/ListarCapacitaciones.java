package cl.awakelab.empresaasesorias.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import cl.awakelab.empresaasesorias.implementacion.CapacitacionImpl;
import cl.awakelab.empresaasesorias.modelo.Capacitacion;

@WebServlet("/listarCapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CapacitacionImpl capacitacionImpl= new CapacitacionImpl();
		List<Capacitacion> capacitaciones = capacitacionImpl.obtenerCapacitaciones();

		request.setAttribute("capacitaciones", capacitaciones);
		request.getRequestDispatcher("listarcapacitaciones.jsp").forward(request, response);

	}

}
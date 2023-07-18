package cl.awakelab.empresaasesorias.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import cl.awakelab.empresaasesorias.implementacion.CapacitacionImpl;
import cl.awakelab.empresaasesorias.modelo.Capacitacion;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/ResumenCapacitacion")
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCapacitacion() {
		super();
		new ArrayList<>();
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
		String nombreCurso = request.getParameter("nombreCurso");
		String detalle = request.getParameter("detalle");
		Capacitacion nuevaCapacitacion = new Capacitacion(nombreCurso, detalle);
		nuevaCapacitacion.setNombre(nombreCurso);
		nuevaCapacitacion.setDetalle(detalle);

		CapacitacionImpl capacitacionImpl= new CapacitacionImpl();
		capacitacionImpl.mostrarCapacitacion(nuevaCapacitacion);
		
		request.getRequestDispatcher("/capacitacion/listarCapacitaciones.jsp").forward(request, response);
	}

}

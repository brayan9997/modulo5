package cl.awakelab.empresaasesorias.implementacion;

import java.util.List;

import cl.awakelab.empresaasesorias.conexion.CapacitacionDAO;
import cl.awakelab.empresaasesorias.interfaces.ICapacitacion;
import cl.awakelab.empresaasesorias.modelo.Capacitacion;

public class CapacitacionImpl implements ICapacitacion{

	@Override
	public List<Capacitacion> obtenerCapacitaciones() {
		 
		 CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();
		 List<Capacitacion> capacitaciones = capacitacionDAO.obtenerCapacitacion();
			   
		return capacitaciones;
	}

	@Override
	public void mostrarCapacitacion(Capacitacion capacitacion) {
		
		CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();
		capacitacionDAO.agregarCapacitacion(capacitacion);
	}

}

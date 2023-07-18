package cl.awakelab.empresaasesorias.interfaces;

import java.util.List;

import cl.awakelab.empresaasesorias.modelo.Capacitacion;

public interface ICapacitacion {

	List<Capacitacion> obtenerCapacitaciones();

	public void mostrarCapacitacion(Capacitacion capacitacion);
}

package cl.awakelab.empresaasesorias.modelo;

public class Capacitacion {
	private int id;
	private String nombre;
	private String detalle;

	// Constructor
	
	public Capacitacion(int id, String nombre, String detalle) {
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
	}


	public Capacitacion(String nombre, String detalle) {
		super();
		this.nombre = nombre;
		this.detalle = detalle;
	}



	public Capacitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
}

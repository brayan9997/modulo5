package cl.awakelab.empresaasesorias.modelo;

public class Usuario {
	protected int id;
	protected String nombre;
	protected TipoUsuario tipo;

	// Constructor
	public Usuario(int id, String nombre, TipoUsuario tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Usuario() {
		super();
	}

	// Getters y setters
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

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	// enum
	public enum TipoUsuario {
		CLIENTE, ADMINISTRATIVO, PROFESIONAL
	}

}

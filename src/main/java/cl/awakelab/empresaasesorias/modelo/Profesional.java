package cl.awakelab.empresaasesorias.modelo;

import java.time.LocalDate;

public class Profesional extends Usuario {
	private String titulo;
	private String fechaIngreso;

	public Profesional() {
		super();
	};

	public Profesional(int id, String nombre, TipoUsuario tipo, String titulo, String fechaIngreso) {
		super(id, nombre, tipo);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String string) {
		this.fechaIngreso = string;
	}

}

package cl.awakelab.empresaasesorias.modelo;

public class Administrativo extends Usuario {

	private String area;
	private String experienciaPrevia;

	public Administrativo() {
		super();
	};

	public Administrativo(int id, String nombre, TipoUsuario tipo, String area, String experienciaPrevia) {
		super(id, nombre, tipo);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

}

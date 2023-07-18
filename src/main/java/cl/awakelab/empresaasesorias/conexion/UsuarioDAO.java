package cl.awakelab.empresaasesorias.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

import cl.awakelab.empresaasesorias.modelo.Administrativo;
import cl.awakelab.empresaasesorias.modelo.Cliente;
import cl.awakelab.empresaasesorias.modelo.Profesional;
import cl.awakelab.empresaasesorias.modelo.Usuario;
import cl.awakelab.empresaasesorias.modelo.Usuario.TipoUsuario;

public class UsuarioDAO {
	private static UsuarioDAO instancia;
	private Connection conexion;

	private UsuarioDAO() {
		// Establecer la conexión a la base de datos en el constructor privado
		// Usar Singleton para asegurar que solo haya una instancia de UsuarioDAO
		// y una única conexión a la base de datos en todo el proyecto
		conexion = obtenerConexion(); // Implementar este método
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	// Métodos CRUD

	public List<Usuario> obtenerUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		String consulta = "SELECT id, nombre, tipo FROM Usuarios";

		try (PreparedStatement statement = conexion.prepareStatement(consulta);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Usuario usuario = null;
				TipoUsuario tipo = TipoUsuario.valueOf(resultSet.getString("tipo").toUpperCase());

				switch (tipo) {
				case ADMINISTRATIVO:
					usuario = new Administrativo();
					break;
				case CLIENTE:
					usuario = new Cliente();
					break;
				case PROFESIONAL:
					usuario = new Profesional();
					break;
				}

				if (usuario != null) {
					usuario.setId(resultSet.getInt("id"));
					usuario.setNombre(resultSet.getString("nombre"));
					usuario.setTipo(tipo);
					usuarios.add(usuario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public Usuario obtenerUsuarioPorId(int id) {
		Usuario usuario = null;
		String consulta = "SELECT id, nombre, tipo, area, experiencia_previa, rut, telefono, afp, sistema_salud, direccion, comuna, edad, titulo, fecha_ingreso FROM Usuarios WHERE id = ?";

		try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
			statement.setInt(1, id);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					TipoUsuario tipo = TipoUsuario.valueOf(resultSet.getString("tipo").toUpperCase());
					usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("nombre"), tipo);

					switch (tipo) {
					case ADMINISTRATIVO:
						Administrativo administrativo = new Administrativo();

						administrativo.setArea(resultSet.getString("area"));
						administrativo.setExperienciaPrevia(resultSet.getString("experiencia_previa"));
						usuario = administrativo;
						break;
					case CLIENTE:
						Cliente cliente = new Cliente();
						cliente.setRut("rut");
						cliente.setTelefono("telefono");
						cliente.setAfp("afp");
						cliente.setSistemaSalud("sistema_salud");
						cliente.setDireccion("direccion");
						cliente.setComuna("comuna");
						cliente.setEdad(Integer.parseInt(resultSet.getString("edad")));
						break;
					case PROFESIONAL:
						Profesional profesional = new Profesional();
						profesional.setTitulo("titulo");
						profesional.setFechaIngreso("fecha_ingreso");
					default:
						usuario = new Usuario();
					}
					usuario.setId(resultSet.getInt("id"));
					usuario.setNombre(resultSet.getString("nombre"));
					usuario.setTipo(tipo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public void agregarUsuario(Usuario usuario) {
		String consulta = "INSERT INTO Usuarios (nombre, tipo";
		String valores = "VALUES (?, ?";
		switch (usuario.getTipo()) {
		case ADMINISTRATIVO:
			consulta += ", area, experiencia_previa)";
			valores += ", ?, ?)";
			break;
		case CLIENTE:
			consulta += ", rut, telefono, afp, sistema_salud, direccion, comuna, edad)";
			valores += ", ?, ?, ?, ?, ?, ?, ?)";
			break;
		case PROFESIONAL:
			consulta += ", titulo, fecha_ingreso)";
			valores += ", ?, ?)";
			break;
		}
		try (PreparedStatement statement = conexion.prepareStatement(consulta + " " + valores)) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getTipo().name());

			switch (usuario.getTipo()) {
			case ADMINISTRATIVO:
				Administrativo administrativo = (Administrativo) usuario;
				statement.setString(3, administrativo.getArea());
				statement.setString(4, administrativo.getExperienciaPrevia());
				break;
			case CLIENTE:
				Cliente cliente = (Cliente) usuario;
				statement.setString(3, cliente.getRut());
				statement.setString(4, cliente.getTelefono());
				statement.setString(5, cliente.getAfp());
				statement.setString(6, cliente.getSistemaSalud());
				statement.setString(7, cliente.getDireccion());
				statement.setString(8, cliente.getComuna());
				statement.setInt(9, cliente.getEdad());
				break;
			case PROFESIONAL:
				Profesional profesional = (Profesional) usuario;
				statement.setString(3, profesional.getTitulo());
				statement.setString(4, profesional.getFechaIngreso());
				break;
			}

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarUsuario(Usuario usuario) {
		String consulta = "UPDATE Usuarios SET nombre = ?, tipo = ?";

		switch (usuario.getTipo()) {
		case ADMINISTRATIVO:
			consulta += ", area=?, experiencia_previa=?)";
			break;
		case CLIENTE:
			consulta += ", rut=?, telefono=?, afp=?, sistema_salud=?, direccion=?, comuna=?, edad=?)";
			break;
		case PROFESIONAL:
			consulta += ", titulo=?, fecha_ingreso=?)";
			break;
		}
		consulta += " WHERE id = ?";

		try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getTipo().name());
			statement.setInt(3, usuario.getId());
			statement.executeUpdate();

			switch (usuario.getTipo()) {
			case ADMINISTRATIVO:
				Administrativo administrativo = (Administrativo) usuario;
				statement.setString(3, administrativo.getArea());
				statement.setString(4, administrativo.getExperienciaPrevia());
				break;
			case CLIENTE:
				Cliente cliente = (Cliente) usuario;
				statement.setString(3, cliente.getRut());
				statement.setString(4, cliente.getTelefono());
				statement.setString(5, cliente.getAfp());
				statement.setString(6, cliente.getDireccion());
				statement.setString(7, cliente.getComuna());
				statement.setInt(8, cliente.getEdad());
				break;
			case PROFESIONAL:
				Profesional profesional = (Profesional) usuario;
				statement.setString(3, profesional.getTitulo());
				statement.setString(4, profesional.getFechaIngreso());
				break;
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarUsuario(int id) {
		String consulta = "DELETE FROM Usuarios WHERE id = ?";

		try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection obtenerConexion() {
		Connection conexion = null;
		try {
			String url = "jdbc:mariadb://localhost:3306/prevencion_riesgos";
			String usuario = "root";
			String password = "1234";
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
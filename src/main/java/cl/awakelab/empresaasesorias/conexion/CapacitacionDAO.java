package cl.awakelab.empresaasesorias.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import cl.awakelab.empresaasesorias.modelo.Capacitacion;

public class CapacitacionDAO {
    private static CapacitacionDAO instancia;
    private Connection conexion;

    private CapacitacionDAO() {
        // Establecer la conexión a la base de datos en el constructor privado
        // Usar Singleton para asegurar que solo haya una instancia de UsuarioDAO
        // y una única conexión a la base de datos en todo el proyecto
        conexion = obtenerConexion(); // Implementar este método
    }

    public static CapacitacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new CapacitacionDAO();
        }
        return instancia;
    }

    // Métodos CRUD

    public List<Capacitacion> obtenerCapacitacion() {
    	
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String consulta = "SELECT id, nombre, detalle FROM Capacitaciones";

        try (
        	 PreparedStatement statement = conexion.prepareStatement(consulta);
        		
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Capacitacion capacitacion = new Capacitacion();
                capacitacion.setId(resultSet.getInt("id"));
                capacitacion.setNombre(resultSet.getString("nombre"));
                capacitacion.setDetalle(resultSet.getString("detalle"));
                capacitaciones.add(capacitacion);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }

    public Capacitacion obtenerCapacitacionPorId(int id) {
        Capacitacion capacitacion = null;
        String consulta = "SELECT id, nombre, tipo FROM capacitaciones WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    capacitacion = new Capacitacion();
                    capacitacion.setId(resultSet.getInt("id"));
                    capacitacion.setNombre(resultSet.getString("nombre"));
                    capacitacion.setDetalle(resultSet.getString("detalle"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitacion;
    }

    public void agregarCapacitacion(Capacitacion capacitacion) {
        String consulta = "INSERT INTO Capacitaciones (nombre, detalle) VALUES (?, ?)";

        try (
        		
        	PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getNombre());
            statement.setString(2, capacitacion.getDetalle());
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
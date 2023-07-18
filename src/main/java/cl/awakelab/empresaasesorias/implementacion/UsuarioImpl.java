package cl.awakelab.empresaasesorias.implementacion;

import java.util.List;

import cl.awakelab.empresaasesorias.conexion.UsuarioDAO;
import cl.awakelab.empresaasesorias.interfaces.IUsuario;
import cl.awakelab.empresaasesorias.modelo.Usuario;

public class UsuarioImpl implements IUsuario {

	@Override
	public void agregarUsuario(Usuario usuario) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		usuarioDAO.agregarUsuario(usuario);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
		return usuarios;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		usuarioDAO.actualizarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuarioporId(int id) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		usuarioDAO.obtenerUsuarioPorId(id);
		Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
		return usuario;
	}

	@Override
	public void eliminarUsuario(int id) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		usuarioDAO.eliminarUsuario(id);
		
	}

}

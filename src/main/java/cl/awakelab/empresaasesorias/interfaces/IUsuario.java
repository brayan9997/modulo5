package cl.awakelab.empresaasesorias.interfaces;

import java.util.List;

import cl.awakelab.empresaasesorias.modelo.Usuario;

public interface IUsuario {

	public void agregarUsuario(Usuario usuario); 
	List<Usuario> obtenerUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioporId(int id);
	
	public void eliminarUsuario(int id);
}

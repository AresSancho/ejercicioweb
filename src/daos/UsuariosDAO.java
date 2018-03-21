package daos;

import java.util.List;

import modelo.Usuario;

public interface UsuariosDAO {

	void registarUsuario(Usuario usuario);
	List<Usuario> obtenerUsuarios();
	boolean identificarUsuario(String email, String pass);
	boolean identificarAdmin(String email, String pass);
	
}

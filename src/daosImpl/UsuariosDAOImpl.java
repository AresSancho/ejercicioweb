package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.UsuariosDAO;

public class UsuariosDAOImpl extends GenericDAO implements UsuariosDAO{

	@Override
	public void registarUsuario(Usuario usuario) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement
						(ConstantesSQL.INSERCION_USUARIO);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPass());
			ps.setString(4, usuario.getPoblacion());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean identificarUsuario(String email, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(
							ConstantesSQL.IDENTIFICACION_USUARIO);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado
				//de base de datos
				identificado = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion tiene problemas");
			System.out.println(e.getMessage());
		}
		desconectar();
		return identificado;
	}//end identificarUsuario

	@Override
	public boolean identificarAdmin(String email, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(
							ConstantesSQL.IDENTIFICACION_ADMIN);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado
				//de base de datos
				identificado = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion tiene problemas");
			System.out.println(e.getMessage());
		}
		desconectar();
		return identificado;
	}//end identificarAdmin


}//end class









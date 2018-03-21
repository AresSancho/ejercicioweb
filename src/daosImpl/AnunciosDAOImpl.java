package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Anuncio;
import daos.AnunciosDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class AnunciosDAOImpl extends GenericDAO implements AnunciosDAO{

	@Override
	public void registrarAnuncio(Anuncio anuncio) {
		conectar();
		try {
			PreparedStatement ps = 
				miConexion.prepareStatement(ConstantesSQL.INSERCION_ANUNCIO);
			ps.setString(1, anuncio.getTitulo());
			ps.setDouble(2, anuncio.getPrecio());
			ps.setString(3, anuncio.getDescripcion());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de anuncio esta mal");
		}		
		desconectar();
	}//end registrarAnuncio

	@Override
	public List<Anuncio> obtenerAnuncios() {
		conectar();
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.SELECCION_ANUNCIOS);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo(resultado.getString("titulo"));
				anuncio.setPrecio(resultado.getDouble("precio"));
				anuncio.setDescripcion(resultado.getString("descripcion"));
				anuncio.setId(resultado.getInt("id"));
				anuncios.add(anuncio);
			}//end while
		} catch (SQLException e) {
			System.out.println("sql select anuncios esta mal");
		}//end catch
		desconectar();
		return anuncios;
	}//end obtenerAnuncios

	@Override
	public Anuncio obtenerAnuncioPorId(int id) {
		conectar();
		Anuncio anuncio = new Anuncio();
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.OBTENER_ANUNCIO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				anuncio.setTitulo(rs.getString("titulo"));
				anuncio.setPrecio(rs.getDouble("precio"));
				anuncio.setDescripcion(rs.getString("descripcion"));
				anuncio.setId(id);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la sql este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return anuncio;
	}

	@Override
	public void guardarCambiosAnuncio(Anuncio anuncio) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.GUARDAR_CAMBIOS_ANUNCIO);
			ps.setString(1, anuncio.getTitulo());
			ps.setDouble(2, anuncio.getPrecio());
			ps.setString(3, anuncio.getDescripcion());
			ps.setInt(4, anuncio.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(
					"posiblemente la sql de guardar cambios este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

}//end class












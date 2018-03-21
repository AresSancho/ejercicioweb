package daos;

public class ConstantesSQL {

	public static final String INSERCION_ANUNCIO = 
			"insert into tabla_anuncios(titulo,precio,descripcion) "
			+ "values(?,?,?)";
	
	public static final String INSERCION_USUARIO = 
			"insert into tabla_usuarios(nombre,email,pass,poblacion) "
			+ "values(?,?,?,?)";

	public static final String SELECCION_ANUNCIOS = 
			"select * from tabla_anuncios";

	public static final String IDENTIFICACION_USUARIO = 
			"select id from tabla_usuarios where email = ? and pass = ? ";	
	
	public static final String IDENTIFICACION_ADMIN = 
			"select id from tabla_usuarios where email = ? and pass = ? and admin = 1 ";

	public static final String OBTENER_ANUNCIO_POR_ID = 
			"select * from tabla_anuncios where id = ? ";

	public static final String GUARDAR_CAMBIOS_ANUNCIO = 	
			"update tabla_anuncios set titulo = ?, precio = ?, descripcion = ? where id=?";
	
	
	
}//end class







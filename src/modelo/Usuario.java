package modelo;

public class Usuario {

	private String nombre;
	private String email;
	private String poblacion;
	private String pass;

	public Usuario() {
	}

	public Usuario(String nombre, String email, String poblacion, String pass) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.poblacion = poblacion;
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email
				+ ", poblacion=" + poblacion + ", pass=" + pass + "]";
	}

}

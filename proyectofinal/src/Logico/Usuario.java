package Logico;

public class Usuario {
	
	private String tipo;
	private String user;
	private String contrasena;
	
	public Usuario(String tipo, String user, String contrasena) {
		super();
		this.tipo = tipo;
		this.user = user;
		this.contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}

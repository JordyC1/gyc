package Logico;

//import java.io.Serializable;

public class Persona implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected String Cedula;
	protected String nombre;
	protected String telefono;
	
	public Persona(String Cedula, String nombre, String telefono) {
		super();
		this.Cedula = Cedula;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String id) {
		this.Cedula = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}

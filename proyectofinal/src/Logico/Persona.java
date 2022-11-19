package Logico;

public class Persona {
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

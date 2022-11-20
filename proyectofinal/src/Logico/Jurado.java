package Logico;

public class Jurado extends Persona{
	
	private String Codjurado;
	private String areaespecializado;

     public Jurado(String Cedula, String nombre, String telefono,String Codjurado,String areaespecializado) {
		super(Cedula, nombre, telefono);
		this.Codjurado=Codjurado;
		this.areaespecializado=areaespecializado;
	}

	public String getCodjurado() {
		return Codjurado;
	}

	public void setCodjurado(String Codjurado) {
		this.Codjurado = Codjurado;
	}

	public String getAreaespecializado() {
		return areaespecializado;
	}

	public void setAreaespecializado(String areaespecializado) {
		this.areaespecializado = areaespecializado;
	}

	
}
package Logico;

import java.util.ArrayList;

public class Jurado extends Miembro{
	private String area;
	private ArrayList<Trabajo>trabajos;

	public Jurado(String id, String nombre, String telefono,String area) {
		super(id, nombre, telefono);
		this.area=area;
		this.trabajos=new ArrayList<>();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	
	
}

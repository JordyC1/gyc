package Logico;

import java.util.ArrayList;

public class Expositores extends Miembro {
	private ArrayList<Evento>actividades;
	
	public Expositores(String id, String nombre, String telefono) {
		super(id, nombre, telefono);
		this.actividades=new ArrayList<>();
	}

	public ArrayList<Evento> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Evento> actividades) {
		this.actividades = actividades;
	}
}

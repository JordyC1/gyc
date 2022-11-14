package Logico;

import java.util.ArrayList;

public class Participante extends Miembro{
	private ArrayList<Trabajo>trabajos;
	private float prompuntos;
	public Participante(String id, String nombre, String telefono,float prompuntos) {
		super(id, nombre, telefono);
		trabajos=new ArrayList<>();
	    this.prompuntos=prompuntos;
	}
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	public float getPrompuntos() {
		return prompuntos;
	}
	public void setPrompuntos(float prompuntos) {
		this.prompuntos = prompuntos;
	}
	
}

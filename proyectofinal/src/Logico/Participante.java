package Logico;

import java.util.ArrayList;

public class Participante extends Persona{
	
	private ArrayList<Trabajo>trabajos;
	private String codparticipante;
	
	public Participante(String id, String nombre, String telefono, String cod) {
		super(id, nombre, telefono);
		trabajos=new ArrayList<>();
	    this.codparticipante= cod;
	}
	
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public String getCodparticipante() {
		return codparticipante;
	}

	public void setCodparticipante(String codparticipante) {
		this.codparticipante = codparticipante;
	}
	
	public void agregartrabajo(Trabajo trabajo) {
		trabajos.add(trabajo);
	}
	
	public float prompuntos() {
		float califtotal=0;
		for (Trabajo trabajo : trabajos) {
			califtotal+=trabajo.getCalificacion();
		}
		return califtotal/trabajos.size();
	}
	
	public void removertrabajo(Trabajo trabajo) {
		int i=0;
		boolean encontrado=false;
		while (i<trabajos.size() && encontrado!=true) {
			if(trabajos.get(i).getCodigo().equalsIgnoreCase(trabajo.getCodigo())) {
				trabajos.remove(i);
				encontrado=true;
			}
			i++;
		}	
	}
	
}
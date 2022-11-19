package Logico;

import java.util.ArrayList;

public class EventoCiencia {
	private ArrayList<Persona>personas;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	
	public EventoCiencia() {
		super();
		this.personas= new ArrayList<>();
		this.trabajos = new ArrayList<>();
		this.recursos = new ArrayList<>();
		this.comisiones=new ArrayList<>();
		this.eventos = new ArrayList<>();
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public ArrayList<Persona> getMiembros() {
		return personas;
	}



	public void setMiembros(ArrayList<Persona> miembros) {
		this.personas = miembros;
	}



	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}



	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<Comision> getComisionesArrayList() {
		return comisiones;
	}

	public void setComisionesArrayList(ArrayList<Comision> comisionesArrayList) {
		this.comisiones = comisionesArrayList;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	//Agregadores
	
	public void agregarpersonas(Persona persona) {
		personas.add(persona);
	}
	
	public void agregartrabajo(Trabajo trabajo) {
		trabajos.add(trabajo);
	}
	
	public void agregarevento(Evento evento) {
		eventos.add(evento);
	}
	
	public void agregarrecurso(Recurso recurso) {
		recursos.add(recurso);
	}
	
	public void agregarcomisiones(Comision comicion) {
		comisiones.add(comicion);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////
	//Buscadores
	
	public Comision buscacomision(String codigo) {
		Comision comi = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < comisiones.size() && encontrado == false) {
			if(comisiones.get(i).getCodigo().equals(codigo))
			{
				encontrado = true;
				comi = comisiones.get(i);
			}
			
			i++;
		}
		
		return comi;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Trabajo mejortrabajadoarea(String codigo) {
		float mayor=0;
		Comision area = buscacomision(codigo);
		Trabajo mejortrabajo = null;
		
		for(int i = 0; i < area.getTrabajos().size(); i++) {
			if(area.getTrabajos().get(i).getCalificacion() > mayor)
			{
				mayor = area.getTrabajos().get(i).getCalificacion();
				mejortrabajo = area.getTrabajos().get(i);
			}
		}
		
		return mejortrabajo;
	}
	
	public Participante mejorparticipante() {
		float mayorprom=0;
		Participante mejorparticipante=null;
		
		for (Persona participante : personas) {
			if(participante instanceof Participante) 
			{	
				if(((Participante) participante).prompuntos() > mayorprom) 
				{
					mayorprom = ((Participante) participante).prompuntos();
					mejorparticipante= (Participante) participante;
				}
			}
		}
		return mejorparticipante;
	}
	
	
}

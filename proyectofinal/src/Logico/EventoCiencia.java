package Logico;

import java.util.ArrayList;

public class EventoCiencia {
	private ArrayList<Participante>participantes;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Jurado>jurados;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	
	public EventoCiencia() {
		super();
		this.participantes = new ArrayList<>();
		this.trabajos = new ArrayList<>();
		this.jurados = new ArrayList<>();
		this.recursos = new ArrayList<>();
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public ArrayList<Jurado> getJurados() {
		return jurados;
	}

	public void setJurados(ArrayList<Jurado> jurados) {
		this.jurados = jurados;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
}

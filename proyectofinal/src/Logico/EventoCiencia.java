package Logico;

import java.util.ArrayList;

public class EventoCiencia {
	private ArrayList<Miembro>miembros;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Jurado>jurados;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	public EventoCiencia() {
		super();
		this.miembros = new ArrayList<>();
		this.trabajos = new ArrayList<>();
		this.jurados = new ArrayList<>();
		this.recursos = new ArrayList<>();
		this.comisiones=new ArrayList<>();
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public ArrayList<Miembro> getMiembros() {
		return miembros;
	}



	public void setMiembros(ArrayList<Miembro> miembros) {
		this.miembros = miembros;
	}



	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}



	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
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
	
	public Trabajo mejortrabajadoarea(Comision area) {
		float mayor=0;
		Trabajo mejortrabajo=null;
		for (Comision comision : comisiones) {
			if(comision.getArea().equalsIgnoreCase(area.getArea())) {
				for (int i = 0; i < comision.getTrabajos().size(); i++) {
					if(comision.getTrabajos().get(i).getCalificacion() > mayor) {
						mayor=comision.getTrabajos().get(i).getCalificacion();
						mejortrabajo=comision.getTrabajos().get(i);
					}
				}
				break;
			}	
		}
		return mejortrabajo;
	}
	public Participante mejorparticipante() {
		float mayorprom=0;
		Participante mejorparticipante=null;
		for (Miembro participante : miembros) {
			if(participante instanceof Participante) {
				if(((Participante) participante).prompuntos()>mayorprom) {
					mayorprom = ((Participante) participante).prompuntos();
					mejorparticipante=(Participante) participante;
				}
			}
		}
		return mejorparticipante;
	}
}

package Logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class EventoCiencia {
	private ArrayList<Persona>personas;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	
	private int codjurado;
	private int codparticipante;
	private int codtrabajo;
	private int codrecurso;
	private int codevento;
	private int codcomision;
	
	
	public EventoCiencia() {
		super();
		this.personas= new ArrayList<>();
		this.trabajos = new ArrayList<>();
		this.recursos = new ArrayList<>();
		this.comisiones=new ArrayList<>();
		this.eventos = new ArrayList<>();
		
		codjurado = 0;
		codparticipante = 0;
		codtrabajo = 0;
		codrecurso = 0;
		codevento = 0;
		codcomision = 0;
	}
	
	public int getCodtrabajo() {
		return codtrabajo;
	}

	public void setCodtrabajo(int codtrabajo) {
		this.codtrabajo = codtrabajo;
	}

	public int getCodcomision() {
		return codcomision;
	}

	public void setCodcomision(int codcomision) {
		this.codcomision = codcomision;
	}

	public int getCodjurado() {
		return codjurado;
	}

	public void setCodjurado(int codjurado) {
		this.codjurado = codjurado;
	}

	public int getCodparticipante() {
		return codparticipante;
	}

	public void setCodparticipante(int codparticipante) {
		this.codparticipante = codparticipante;
	}

	public int getCodrecurso() {
		return codrecurso;
	}

	public void setCodrecurso(int codrecurso) {
		this.codrecurso = codrecurso;
	}

	public int getCodevento() {
		return codevento;
	}

	public void setCodevento(int codevento) {
		this.codevento = codevento;
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void serPersonas(ArrayList<Persona> persona) {
		this.personas = persona;
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
		
		if(persona instanceof Participante)
			codparticipante++;
		if(persona instanceof Jurado)
			codjurado++;
	}
	
	public void agregartrabajo(Trabajo trabajo) {
		trabajos.add(trabajo);
		codtrabajo++;
	}
	
	public void agregarevento(Evento evento) {
		eventos.add(evento);
		codevento++;
	}
	
	public void agregarrecurso(Recurso recurso) {
		recursos.add(recurso);
		codrecurso++;
	}
	
	public void agregarcomisiones(Comision comicion) {
		comisiones.add(comicion);
		codcomision++;
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
	
	public Trabajo buscatrabajo(String codigo) {
		Trabajo trab = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < trabajos.size() && encontrado == false) {
			if(trabajos.get(i).getCodigo().equals(codigo))
			{
				encontrado = true;
				trab = trabajos.get(i);
			}
			
			i++;
		}
		
		return trab;
	}
	
	public Participante buscaparticipante(String codigo) {
		Participante parti = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < personas.size() && encontrado == false) {
			if(personas.get(i) instanceof Participante)
			{
				if(((Participante)personas.get(i)).getCodparticipante().equals(codigo))
				{
					encontrado = true;
					parti = (Participante)personas.get(i);
				}
			}
			
			i++;
		}
		
		return parti;
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
	
	public void agregartrabajo(String cod,String titulo, String codparticipante, Comision comi){
		Participante parti = buscaparticipante(codparticipante);
		
		Trabajo trabajo = new Trabajo(cod, parti, titulo);
		
		agregartrabajo(trabajo);
		comi.agregartrabajos(trabajo);
		parti.agregartrabajo(trabajo);
	}
	
	public void evaluartrabajo(String codtrabajo, float evaluacion){
		Trabajo trab = buscatrabajo(codtrabajo);
		trab.agregarcalif(evaluacion);
	}
	
	public void agregarrecursoevento(Recurso cosa, Evento event) {
		event.agregarrecurso(cosa);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//funciones para guardar y cargar
	
	public void guardarpersona() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("Personas.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(personas.size());
		
		for(int i = 0; i < personas.size(); i ++) {
			guardador.writeObject(personas.get(i));
		}
		
		//guardador.close();
		f.close();
	}
	
	public void cargarpersona() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream ("Personas.dat");
		ObjectInputStream cargador = new ObjectInputStream(f);
		int size = cargador.readInt();
		
		for (int i = 0; i < size; i++){	
			Persona aux = (Persona)cargador.readObject();
			personas.add(aux);
		}
		cargador.close();
		f.close();
	}
	
	public void guardartodo(){
	}
	
	public void cargartodo() {
		
	}
	
	
}

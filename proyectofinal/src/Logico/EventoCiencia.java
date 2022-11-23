package Logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class EventoCiencia {
	private ArrayList<Persona>personas;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	private static EventoCiencia event = null;
	
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
		
		codjurado = 1;
		codparticipante = 1;
		codtrabajo = 1;
		codrecurso = 1;
		codevento = 1;
		codcomision = 1;
	}
	
	public static EventoCiencia getInstance(){
		   if(event == null){
			 event = new EventoCiencia();  
		   } 	   
		   return event;
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
	
	
	public Recurso buscarrecurso(String codigo) {
		Recurso recu = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < recursos.size() && encontrado == false) {
			if(recursos.get(i).getCodigo().equals(codigo))
			{
				encontrado = true;
				recu = recursos.get(i);
			}
			
			i++;
		}
		
		return recu;
	}
	
	public Evento buscarevento(String codigo) {
		Evento event = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < eventos.size() && encontrado == false) {
			if(eventos.get(i).getCodigo().equals(codigo))
			{
				encontrado = true;
				event = eventos.get(i);
			}
			
			i++;
		}
		
		return event;
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

	/*
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//funciones para guardar
	
	public void guardarpersona() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("Personas.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(personas.size());
		
		for(int i = 0; i < personas.size(); i ++) {
			guardador.writeObject(personas.get(i));
		}
		
		guardador.close();
		f.close();
	}
	
	public void guardarcomision() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("comisiones.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(comisiones.size());
		
		for(int i = 0; i < comisiones.size(); i ++) {
			guardador.writeObject(comisiones.get(i));
		}
		
		guardador.close();
		f.close();
	}
	
	public void guardarevento() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("eventos.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(eventos.size());
		
		for(int i = 0; i < eventos.size(); i ++) {
			guardador.writeObject(eventos.get(i));
		}
		
		guardador.close();
		f.close();
	}
	
	public void guardarrecurso() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("recursos.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(recursos.size());
		
		for(int i = 0; i < recursos.size(); i ++) {
			guardador.writeObject(recursos.get(i));
		}
		
		guardador.close();
		f.close();
	}
	
	public void guardartrabajo() throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream ("trabajos.dat");
		ObjectOutputStream guardador = new ObjectOutputStream(f);
		
		guardador.writeInt(trabajos.size());
		
		for(int i = 0; i < trabajos.size(); i ++) {
			guardador.writeObject(trabajos.get(i));
		}
		
		guardador.close();
		f.close();
	}
	
	public void guardartodo() throws IOException, ClassNotFoundException{
		guardarcomision();
		guardarevento();
		guardarpersona();
		guardarrecurso();
		guardartrabajo();
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//funciones para cargar
	
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
	
	public void cargarcomsision() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream ("comisiones.dat");
		ObjectInputStream cargador = new ObjectInputStream(f);
		int size = cargador.readInt();
		
		for (int i = 0; i < size; i++){	
			Comision aux = (Comision)cargador.readObject();
			comisiones.add(aux);
		}
		cargador.close();
		f.close();
	}
	
	public void cargarevento() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream ("eventos.dat");
		ObjectInputStream cargador = new ObjectInputStream(f);
		int size = cargador.readInt();
		
		for (int i = 0; i < size; i++){	
			Evento aux = (Evento)cargador.readObject();
			eventos.add(aux);
		}
		cargador.close();
		f.close();
	}
	
	public void cargarrecurso() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream ("recursos.dat");
		ObjectInputStream cargador = new ObjectInputStream(f);
		int size = cargador.readInt();
		
		for (int i = 0; i < size; i++){	
			Recurso aux = (Recurso)cargador.readObject();
			recursos.add(aux);
		}
		cargador.close();
		f.close();
	}
	
	public void cargartrabajo() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream ("trabajos.dat");
		ObjectInputStream cargador = new ObjectInputStream(f);
		int size = cargador.readInt();
		
		for (int i = 0; i < size; i++){	
			Trabajo aux = (Trabajo)cargador.readObject();
			trabajos.add(aux);
		}
		cargador.close();
		f.close();
	}
	
	public void cargartodo() throws IOException, ClassNotFoundException{
		cargarcomsision();
		cargarevento();
		cargarpersona();
		cargarrecurso();
		cargartrabajo();
	}
	
	*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Funciones de eliminacion
	
	public void eliminarRecurso(String codigo) {
		int ind = indRecurso(codigo);
		
		if(ind != -1)
			recursos.remove(ind);
	}
	
	public int indRecurso(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < recursos.size() && seguir == true)
		{
			if(recursos.get(i).getCodigo().equals(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	
}

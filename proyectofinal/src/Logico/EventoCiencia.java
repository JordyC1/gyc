package Logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class EventoCiencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> usuarios;
	private Usuario nowuser;
	
	private ArrayList<Persona>personas;
	private ArrayList<Trabajo>trabajos;
	private ArrayList<Evento>eventos;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	private ArrayList<Comision>comisionesaux;
	private static EventoCiencia event = null;
	
	private int codjurado;
	private int codparticipante;
	private int codtrabajo;
	private int codrecurso;
	private int codevento;
	private int codcomision;
	
	
	public EventoCiencia() {
		super();
		this.usuarios = new ArrayList<>();
		this.personas= new ArrayList<>();
		this.trabajos = new ArrayList<>();
		this.recursos = new ArrayList<>();
		this.comisiones=new ArrayList<>();
		this.eventos = new ArrayList<>();
		this.comisionesaux=new ArrayList<>();
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
	
	public void agregarcomisionesaux(Comision com) {
		comisionesaux.add(com);
		codcomision++;
	}
	
	public ArrayList<Comision> getcomisionesaux() {
		return comisionesaux;
	}
	
	public static void setCiencia(EventoCiencia aux) {
		EventoCiencia.event = aux;
	}
	
	
	public Usuario getUser() {
		return nowuser;
	}

	public void setUser(Usuario user) {
		this.nowuser = user;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
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

	public void setPersonas(ArrayList<Persona> persona) {
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
	}
	
	public void reguser(Usuario aux) {
		usuarios.add(aux);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////
	//Buscadores
	
	public Usuario buscarusuario(String usuario) {
		Usuario usu = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < usuarios.size() && encontrado == false) {
			if(usuarios.get(i).getUser().equals(usuario))
			{
				encontrado = true;
				usu = usuarios.get(i);
			}
			
			i++;
		}
		
		return usu;
	}
	
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
	
	public Evento buscarEvento(String codigo) {
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
	
	public Participante buscaparticipantebycedula(String cedula) {
		Participante parti = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < personas.size() && encontrado == false) {
			if(personas.get(i) instanceof Participante)
			{
				if(((Participante)personas.get(i)).getCedula().equals(cedula))
				{
					encontrado = true;
					parti = (Participante)personas.get(i);
				}
			}
			
			i++;
		}
		
		return parti;
	}
	
	public Jurado buscarJurado(String codigo) {
		Jurado parti = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < personas.size() && encontrado == false) {
			if(personas.get(i) instanceof Jurado)
			{
				if(((Jurado)personas.get(i)).getCodjurado().equals(codigo))
				{
					encontrado = true;
					parti = (Jurado)personas.get(i);
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
		trab.agregarcalificacion(evaluacion);
	}
	
	public void agregarrecursoevento(Recurso cosa, Evento event) {
		event.agregarrecurso(cosa);
	}
	
	public boolean buscarPresidentesrepetidos(Evento evento) {
		boolean presidenterepetido=false;
		Comision comiaux=null;
		int i,j;
		
		for (i = 0; i < evento.getComisiones().size() && presidenterepetido==false; i++) {	
			comiaux=evento.getComisiones().get(i);
			for ( j = i+1; j < evento.getComisiones().size() && presidenterepetido==false; j++) {
				if(comiaux.getPresidente().equals(evento.getComisiones().get(j).getPresidente())) {
					presidenterepetido=true;
				}else if(comiaux.getJurados().equals(evento.getComisiones().get(j).getJurados())){
					presidenterepetido=true;
				}
			}
			
		}
		return presidenterepetido;
	}

	
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
	
	public void eliminarTrabajo(Trabajo trabajo) {
		int ind = indTrabajo(trabajo.getCodigo());
		
		if(ind != -1)
			trabajos.remove(ind);
	}
	
	public int indTrabajo(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < trabajos.size() && seguir == true)
		{
			if(trabajos.get(i).getCodigo().equals(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	
	public void eliminarjurado(String codigo) {
		int ind=indjurado(codigo);
		if(ind != -1)
			personas.remove(ind);
	}
	
	public void eliminarparticipante(String codigo) {
		int ind=indparticipante(codigo);
		if(ind != -1)
			personas.remove(ind);
	}
	
	public void modifJurado(Jurado jurado) {
		int ind=indjurado(jurado.getCodjurado());
		if(ind != -1)
			personas.set(ind, jurado);
	}
	
	public int indjurado(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < personas.size() && seguir == true)
		{
			if(personas.get(i) instanceof Jurado && ((Jurado)personas.get(i)).getCodjurado().equals(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	
	public void modifevento(Evento evento) {
		int ind=indevento(evento.getCodigo());
		if(ind != -1)
			eventos.set(ind, evento);
	}
	
	public void modifparticipante(Participante participante) {
		int ind=indparticipante(participante.getCodparticipante());
		if(ind != -1)
			personas.set(ind, participante);
	}
	
	public int indevento(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < eventos.size() && seguir == true)
		{
			if(eventos.get(i).getCodigo().equalsIgnoreCase(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	public void modicomision(Comision comision) {
		int ind=indcomision(comision.getCodigo());
		if(ind != -1)
			comisiones.set(ind, comision);
	}
	
	public int indcomision(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < comisiones.size() && seguir == true)
		{
			if(comisiones.get(i).getCodigo().equalsIgnoreCase(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	public int indparticipante(String codigo) {
		int posi = -1;
		int i = 0;
		boolean seguir = true;
		
		while(i < personas.size() && seguir == true)
		{
			if(personas.get(i) instanceof Participante && ((Participante)personas.get(i)).getCodparticipante().equals(codigo))
			{
				posi = i;
				seguir = false;
			}	
			i++;
		}
		
		return posi;
	}
	
	
	public void eliminarcomision(String codigo) {
		int ind = indcomision(codigo);
		
		if(ind != -1)
			comisiones.remove(ind);
	}
	
	public void eliminarevento(String codigo) {
		int ind = indevento(codigo);
		
		if(ind != -1)
			eventos.remove(ind);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean confirmLogin(String usuar, String contra) {
		boolean login = false;
		//System.out.println(usuarios.size());
		for (Usuario user : usuarios) {
			if(user.getUser().equals(usuar) && user.getContrasena().equals(contra)){
				nowuser = user;
				login = true;
			}
		}
		return login;
	}
	
	public ArrayList<Evento> eventosdejurado(String codjurado){
		ArrayList<Evento> event	= new ArrayList<>();
		
		for (Evento evento : eventos) {
			for (Comision comi : evento.getComisiones()) {
				for (Jurado jurad : comi.getJurados()) {
					if(jurad.getCodjurado().equals(codjurado))
					{
						event.add(evento);
					}
				}
			}
		}	
		return event;
	}
	
	public ArrayList<Comision> comisiondejurado(String codjurado,Evento event){
		ArrayList<Comision> comis = new ArrayList<>();
		
		for (Comision comi : event.getComisiones()) {
			for (Jurado jurad : comi.getJurados()) {
				if(jurad.getCodjurado().equals(codjurado))
				{
					comis.add(comi);
				}
			}
		}
		
		return comis;
	}
	
	public ArrayList<Comision> todascomisionesdejurado(String codjurado){
		ArrayList<Comision> comis = new ArrayList<>();
		
		for (Comision comic : comisiones) {
			for (Jurado jura : comic.getJurados()) {
				if(jura.getCodjurado().equals(codjurado))
					comis.add(comic);
			}
		}
		
		return comis;
	}
	
	public int cantparticipanteevento(String codevento) {
		Evento event = buscarevento(codevento);
		ArrayList<Participante> partis = new ArrayList<>();
		int cant = 0;
		
		for (Comision comi : event.getComisiones()) {
			for (Trabajo trab : comi.getTrabajos()) {
				if(!(estaparticipante(trab.getPropietario().getCodparticipante(), partis)))
					partis.add(trab.getPropietario());
			}	
		}
		
		cant = partis.size();
		
		return cant;
	}
	
	public boolean estaparticipante(String cod,ArrayList<Participante> parti) {
		boolean veredict = false;
		int i = 0;
		
		while(veredict == false && i < parti.size())
		{
			if(parti.get(i).getCodparticipante().equals(cod))
				veredict = true;
			
			i++;
		}
		
		return veredict;
	}
	
	
}

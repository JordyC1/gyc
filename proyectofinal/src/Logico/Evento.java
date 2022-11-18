package Logico;

import java.sql.Date;
import java.util.ArrayList;

public class Evento {
	private String nombre;
	private String codigo;
	private Date fechainicio;
	private Date fechafinal;
	private ArrayList<Participante>participantes;
	
	public Evento(String nombre, String codigo, Date fechainicio,Date fechafinal) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.fechainicio = fechainicio;
		this.fechafinal=fechafinal;
		this.participantes = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}
	
	
}

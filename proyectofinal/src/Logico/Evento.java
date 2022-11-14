package Logico;

import java.sql.Date;
import java.util.ArrayList;

public class Evento {
	protected String nombre;
	protected String codigo;
	protected Date fecha;
	protected ArrayList<Participante>participantes;
	
	public Evento(String nombre, String codigo, Date fecha) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	
}

package Logico;


import java.util.Date;
import java.util.ArrayList;

public class Evento implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String codigo;
	private String ubicacion;
	private Date fechainicio;
	private Date fechafinal;
	private int cupo;
	private ArrayList<Recurso>recursos;
	private ArrayList<Comision>comisiones;
	
	public Evento(String nombre, String codigo,String ubicacion, Date fechainicio,Date fechafinal,int cupo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.ubicacion=ubicacion;
		this.fechainicio = fechainicio;
		this.fechafinal=fechafinal;
		this.cupo=cupo;
		this.comisiones = new ArrayList<>();
		this.recursos = new ArrayList<>();
	}
	
	public void agregarcomision(Comision c) {
		comisiones.add(c);
	}
	
	public void agregarrecurso(Recurso cosa) {
		recursos.add(cosa);
		cosa.setUbicacion(ubicacion);
		cosa.setdisponible(false);
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursoss) {
		for (Recurso recurso : recursoss) {
			agregarrecurso(recurso);
		}
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		for (Comision comi : comisiones) {
			agregarcomision(comi);
		}
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

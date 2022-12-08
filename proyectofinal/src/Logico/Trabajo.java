package Logico;

import java.util.ArrayList;

public class Trabajo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private Participante propietario;
	private float calificacion;
	private String titulo;
	private boolean primeracalificaion;
	private ArrayList<String> calificadopor;
	
	public Trabajo(String codigo, Participante propietario, String titulo) {
		super();
		this.codigo = codigo;
		this.propietario = propietario;
		calificacion = 0;
		this.titulo = titulo;
		primeracalificaion = false;
		calificadopor=new ArrayList<>();
	}
	

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Participante getPropietario() {
		return propietario;
	}
	public void setPropietario(Participante propietario) {
		this.propietario = propietario;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	public String gettitulo() {
		return titulo;
	}
	public void settitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void agregarcalif(float calif) {
		this.calificacion=calif;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void agregarcalificacion(float calif) {
		if(primeracalificaion == false)
		{
			calificacion = calif;
			primeracalificaion = true;
		}
		else
			calificacion = (calif + calificacion) / 2;
			
	}
	
	public void calificadopor(Jurado jurado) {
		calificadopor.add(jurado.getCodjurado());
	}
	
	public boolean verificarcalificacion(Jurado jurado) {
		boolean yacalificado=false;
		int i=0;
		while(i < calificadopor.size() && yacalificado!=true) {
			if(calificadopor.get(i).equalsIgnoreCase(jurado.getCodjurado())) {
				yacalificado=true;
			}
		}
		return yacalificado;
	}
}

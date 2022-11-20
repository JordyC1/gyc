package Logico;

import java.util.ArrayList;

public class Comision implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String area;
	private Jurado presidente;
	private ArrayList<Jurado>jurados;
	private ArrayList<Trabajo>trabajos;
	
	public Comision(String codigo, String area, Jurado presidente) {
		super();
		this.codigo = codigo;
		this.area = area;
		this.presidente = presidente;
		this.jurados=new ArrayList<>();
		this.trabajos=new ArrayList<>();
	}

	public void agregarjurados(Jurado j) {
		jurados.add(j);
	}
	public void agregartrabajos(Trabajo trabajo) {
		trabajos.add(trabajo);
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Jurado getPresidente() {
		return presidente;
	}

	public void setPresidente(Jurado presidente) {
		this.presidente = presidente;
	}

	public ArrayList<Jurado> getJurados() {
		return jurados;
	}

	public void setJurados(ArrayList<Jurado> jurados) {
		this.jurados = jurados;
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	

}

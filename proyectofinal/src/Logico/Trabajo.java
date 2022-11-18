package Logico;

public class Trabajo {
	private String codigo;
	private Participante propietario;
	private float calificacion;
	private String titulo;
	public Trabajo(String codigo, Participante propietario, float calificacion, String titulo) {
		super();
		this.codigo = codigo;
		this.propietario = propietario;
		this.calificacion = calificacion;
		this.titulo = titulo;
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
	
}

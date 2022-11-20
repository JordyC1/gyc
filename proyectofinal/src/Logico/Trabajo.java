package Logico;

public class Trabajo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private Participante propietario;
	private float calificacion;
	private String titulo;
	private boolean primeracalificaion;
	
	public Trabajo(String codigo, Participante propietario, String titulo) {
		super();
		this.codigo = codigo;
		this.propietario = propietario;
		calificacion = 0;
		this.titulo = titulo;
		primeracalificaion = false;
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
			calificacion = (calif + calificacion);
			primeracalificaion = true;
		}
		else
			calificacion = (calif + calificacion) / 2;
	}
	
}

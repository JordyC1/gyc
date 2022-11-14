package Logico;

public class Recurso {
 private String codigo;
 private String estado;
 private String ubicacion;
 private String tipo;
public Recurso(String codigo, String estado, String ubicacion, String tipo) {
	super();
	this.codigo = codigo;
	this.estado = estado;
	this.ubicacion = ubicacion;
	this.tipo = tipo;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getUbicacion() {
	return ubicacion;
}
public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
}

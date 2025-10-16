package logica;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import logica.TipoRetorno;

public class DTPropCompleto {
	private String titulo;
	private String descripcion;
	private byte[] imagen;
	private String lugar;
	private LocalDate fecha;
	private float precio;
	private float montoNecesario;
	private LocalDate fechaPublicacion;
	private List<Estado> estados;
	private TipoRetorno tipoRetorno;
	
	

	public void setTipoRetorno(logica.TipoRetorno tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	
public DTPropCompleto() {
	
}

public DTPropCompleto(Propuesta prop) {
    this.titulo = prop.getTitulo();
    this.descripcion = prop.getDescripcion();
    this.imagen = prop.getImagen();
    this.lugar = prop.getLugar();
    this.fecha = prop.getFecha();
    this.precio = prop.getPrecio();
    this.montoNecesario = prop.getMontoNecesario();
    this.fechaPublicacion = prop.getFechaPublicacion();
    this.estados = prop.getEstados();
    this.tipoRetorno = prop.getTipoRetorno();
}

//GETTERS
public String getTitulo() {
	return titulo;
}
public String getDescripcion() {
	return descripcion;  //Es lo mismo que ponerlo con el this
}
public byte[] getImagen() {
	return imagen;
}
public String getLugar() {
	return lugar;
}
public LocalDate getFecha() {
	return fecha;
}
public float getPrecio() {
	return precio;
}
public float getMontoNecesario() {
	return montoNecesario;
}
public TipoRetorno getTipoRetorno() {
	return tipoRetorno;
}
public LocalDate fechaPublicacion() {
	return fechaPublicacion;
}
public List<Estado> getEstados(){
	return estados;
}

//SETTERS
public void setTitulo(String _titulo) {
	this.titulo = _titulo;
}
public void setDescripcion(String _descripcion) {
	this.descripcion = _descripcion;
}
public void setImagen(byte[] imagen2) {
	this.imagen = imagen2;
}
public void setLugar(String _lugar){
	this.lugar = _lugar;
}
public void setFecha(LocalDate _fecha) {
	this.fecha = _fecha;
}
public void setPrecio(float _precio) {
	this.precio = _precio;
}
public void setMontoNecesario(float _montoNecesario) {
	this.montoNecesario = _montoNecesario;
}
public void setfechaPublicacion(LocalDate _fechaPublicacion) {
	this.fechaPublicacion = _fechaPublicacion;
}

public void setEstado(List<Estado> _estados){
	this.estados = _estados;
}

public static Estado ultimoEstado(List<Estado> estados) { //lo hice estatico para poder llamarlo en la ventana.
    if (estados == null || estados.isEmpty()) {
        Estado estadoDefault = new Estado();
        estadoDefault.setEstado(EstadoENUM.INGRESADA);
        return estadoDefault;
    }
    // El estado más actual está en el último lugar de la lista
    return estados.get(estados.size() - 1);
}
}

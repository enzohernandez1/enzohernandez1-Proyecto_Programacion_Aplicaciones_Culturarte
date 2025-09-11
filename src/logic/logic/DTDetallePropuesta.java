package logic;

import java.util.List;

public class DTDetallePropuesta {
    private String titulo;
    private String proponente;
    private String tipoEspectaculo;
    private String lugar;
    private String fecha;
    private String fechaPublicacion;
    private float precio;
    private float montoNecesario;
    private float montoRecaudado;
    private String estado;
    private String descripcion;
    private byte[] imagen;
    private List<String> colaboradores;
    private String tipoRetorno;

    public DTDetallePropuesta(String titulo, String proponente, String tipoEspectaculo, String lugar, String fecha, String fechaPublicacion, float precio, float montoNecesario, float montoRecaudado, String estado, String descripcion, byte[] imagen, List<String> colaboradores, String tipoRetorno) {
        this.titulo = titulo;
        this.proponente = proponente;
        this.tipoEspectaculo = tipoEspectaculo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.montoRecaudado = montoRecaudado;
        this.estado = estado;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.colaboradores = colaboradores;
        this.tipoRetorno = tipoRetorno;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getProponente() {
        return proponente;
    }

    public String getTipoEspectaculo() {
        return tipoEspectaculo;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public float getPrecio() {
        return precio;
    }

    public float getMontoNecesario() {
        return montoNecesario;
    }

    public float getMontoRecaudado() {
        return montoRecaudado;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public List<String> getColaboradores() {
        return colaboradores;
    }
    
    public String getTipoRetorno() {
    	return tipoRetorno;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public void setTipoEspectaculo(String tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMontoNecesario(float montoNecesario) {
        this.montoNecesario = montoNecesario;
    }

    public void setMontoRecaudado(float montoRecaudado) {
        this.montoRecaudado = montoRecaudado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public void setColaboradores(List<String> colaboradores) {
        this.colaboradores = colaboradores;
    }
    
    public void setTipoRetorno(String tipoRetorno) {
    	this.tipoRetorno = tipoRetorno;
    }
}
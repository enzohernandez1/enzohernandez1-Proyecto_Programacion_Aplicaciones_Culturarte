package logica;

import java.time.LocalDate;


public class DTPropuesta {
	private long id;
    private String nicknameProponente;
    private String titulo;
    private String descripcion;
    private byte[] imagen;
    private String lugar;
    private LocalDate fecha;
    private float precio;
    private float montoNecesario;
    private TipoRetorno tipoRetorno;
    private String nombreCategoria;
    private Estado estadoActual;

    public DTPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria) {
        this.nicknameProponente = nicknameProponente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.tipoRetorno = tipoRetorno;
        this.nombreCategoria = nombreCategoria;
    }
    
    public DTPropuesta(Long id, String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria) {
        this.id = id;
        this.nicknameProponente = nicknameProponente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.tipoRetorno = tipoRetorno;
        this.nombreCategoria = nombreCategoria;
    }

    public DTPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria, Estado estadoActual) {
        this.nicknameProponente = nicknameProponente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.tipoRetorno = tipoRetorno;
        this.nombreCategoria = nombreCategoria;
        this.estadoActual = estadoActual;
    }
    
    public DTPropuesta(Long id,String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria, Estado estadoActual) {
        this.id = id;
        this.nicknameProponente = nicknameProponente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.tipoRetorno = tipoRetorno;
        this.nombreCategoria = nombreCategoria;
        this.estadoActual = estadoActual;
    }

    // Getters
    
    public DTPropuesta(Long id, String titulo, String nickname, Estado estadoActual) {
    	this.id = id;
		this.titulo = titulo;
		this.nicknameProponente = nickname;
		this.estadoActual = estadoActual;
	}

	public long  getId() {
    	return id;
    }
    
    public Estado getEstado() {
    	return estadoActual;
    }
    
    public String getNicknameProponente() {
    	return nicknameProponente; 
    }
    
    public String getTitulo() {
    	return titulo; 
    }
    
    public String getDescripcion() {
    	return descripcion; 
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
    
    public String getNombreCategoria() {
    	return nombreCategoria; 
    	}

}
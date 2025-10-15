	package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="propuesta")

public class Propuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(name="descripcion",length=1000)
    private String descripcion;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
    private byte[] imagen;
    private String lugar;
    private LocalDate fecha;
    private float precio;
    private float montoNecesario;
    private LocalDate fechaPublicacion;

    @OneToMany(mappedBy = "propuesta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estado> estados = new ArrayList<>();

	@Enumerated(EnumType.STRING)
    private TipoRetorno tipoRetorno;

    @ManyToOne
    private Proponente proponente;

    @ManyToOne
    private Categoria tipoEspectaculo;

    @OneToMany(mappedBy = "propuesta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aporte> aportes = new ArrayList<>();
    
    public Propuesta(String titulo, String descripcion, byte[] imagen, String lugar, LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, Proponente proponente, Categoria tipoEspectaculo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.montoNecesario = montoNecesario;
        this.tipoRetorno = tipoRetorno;
        this.proponente = proponente;
        this.tipoEspectaculo = tipoEspectaculo;
        this.fechaPublicacion = LocalDate.now();
        this.aportes = new ArrayList<>();
        Estado estadoInicial = new Estado(EstadoENUM.INGRESADA, LocalDate.now(), this);
        this.estados.add(estadoInicial);
    }
    
    public Propuesta() {

    }
    
    // Getters
    
    public Long getID() {
    	return id;
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
    
    public LocalDate getFechaPublicacion() {
    	return fechaPublicacion; 
    }
    
    public TipoRetorno getTipoRetorno() {
    	return tipoRetorno; 
    }
    
    public Proponente getProponente() {
    	return proponente; 
    }
    
    public Categoria getTipoEspectaculo() {
    	return tipoEspectaculo;
    }

    public List<Estado> getEstados() {
    	return this.estados;
    }
    
    public List<Aporte> getAportes() {
        return aportes;
    }
    
    public Estado EstadoActual() {
        if (estados == null || estados.isEmpty()) {
            Estado estadoDefault = new Estado();
            estadoDefault.setEstado(logica.EstadoENUM.INGRESADA);
            return estadoDefault;
        }
        // El estado más actual está en el último lugar de la lista
        return estados.get(estados.size() - 1);
}
    
    //Setters
    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }
    
    public void setTitulo(String titulo) {
    	this.titulo = titulo; 
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion; 
   	}
    
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    public void setLugar(String lugar) {
    	this.lugar = lugar; 
   	}
    
    public void setFecha(LocalDate fecha) {
    	this.fecha = fecha; 
   	}
    
    public void setPrecio(float precio) {
    	this.precio = precio; 
   	}
    
    public void setMontoNecesario(float montoNecesario) {
    	this.montoNecesario = montoNecesario; 
   	}
    
    public void setTipoRetorno(TipoRetorno tipoRetorno) {
    	this.tipoRetorno = tipoRetorno; 
   	}
    
    public void setTipoEspectaculo(Categoria tipoEspectaculo) {
    	this.tipoEspectaculo = tipoEspectaculo; 
   	}
    
    public Estado getEstadoActual() {
    	if (estados == null || estados.isEmpty()) return null;
    	return estados.get(estados.size() - 1);
    }

    public void cambiarEstado(EstadoENUM estado) {
    Estado nuevoEstado = new Estado(estado, java.time.LocalDate.now(), this);
    this.estados.add(nuevoEstado);
    }
    
    public void setCategoria(Categoria categoria) {
        this.tipoEspectaculo = categoria;
    }
    
    public void setProponente(Proponente p) {	
    	this.proponente = p;
    }
    
    public void AgregarAporte(Aporte p) {
    	aportes.add(p);
    	p.setPropuesta(this);
    }
    
    public DTPropCompleto getInfo() {
        DTPropCompleto Propuesta = new DTPropCompleto();
        Propuesta.setTitulo(this.titulo);
        Propuesta.setDescripcion(this.descripcion);
        Propuesta.setImagen(this.imagen);
        Propuesta.setLugar(this.lugar);
        Propuesta.setFecha(this.fecha);
        Propuesta.setPrecio(this.precio);
        Propuesta.setMontoNecesario(this.montoNecesario);
        Propuesta.setfechaPublicacion(this.fechaPublicacion);
        Propuesta.setEstado(this.estados);
        Propuesta.setTipoRetorno(this.tipoRetorno);
        return Propuesta;
      	}

}
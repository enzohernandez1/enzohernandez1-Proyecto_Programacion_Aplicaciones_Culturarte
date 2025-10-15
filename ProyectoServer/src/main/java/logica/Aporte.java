package logica;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aporte")
public class Aporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float monto;
	private LocalDate fechaAporte;
	@Enumerated(EnumType.STRING)
	private TipoRetorno retorno;

	@ManyToOne
	private Colaborador colaborador;

	@ManyToOne
	private Propuesta propuesta;
	
	//NO BORRAR CONTRUCTOR- LO PRECISA EL HIBERNATE
	public Aporte() {
		
	}
	public Aporte(float monto, LocalDate fechaAporte, TipoRetorno retorno) {
		this.id = id;
		this.monto = monto;
		this.fechaAporte = fechaAporte;
		this.retorno = retorno;
		
	}
	
	public Aporte(float monto, LocalDate fechaAporte, TipoRetorno retorno,Colaborador colab, Propuesta prop) {
		this.monto = monto;
		this.fechaAporte = fechaAporte;
		this.retorno = retorno;
		this.colaborador = colab;
		colab.getAporte().add(this);//la relacion
		this.propuesta = prop;
	}
	
	// GETTERS
	public Long getId() {
		return this.id;
	}
	public float getMonto() {
		return this.monto;
	}
	public LocalDate getFecha() {
		return this.fechaAporte;
	}
	public TipoRetorno getRetorno() {
		return this.retorno;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public Propuesta getPropuesta() {
		return propuesta;
	}
	public String getTituloPropuesta() {
		return propuesta.getTitulo();
	}
	
	// SETTERS
	public void setId(Long id) {
		this.id = id;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public void setFecha(LocalDate fecha) {
		this.fechaAporte = fecha;
	}
	public void setRetorno(TipoRetorno retorno) {
		this.retorno = retorno;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}
	
	public DTInfoAporte pasoDT() { 
		return new DTInfoAporte(this.monto, this.fechaAporte,this.retorno,this.getTituloPropuesta());
	}
	
}

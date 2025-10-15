package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private EstadoENUM est;
	private LocalDate fecha;
	@ManyToOne
	private Propuesta propuesta;
	
	public Estado() {

	}
	
	public Estado(EstadoENUM est, LocalDate fecha) {
		this.est = est;
		this.fecha = fecha;
	}

	public Estado(EstadoENUM est, LocalDate fecha, Propuesta propuesta) {
		this.est = est;
		this.fecha = fecha;
		this.propuesta = propuesta;
	}
	
	public EstadoENUM getEstado() {
		return this.est;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void setEstado(EstadoENUM estado) {
		this.est = estado;
	}
}

package logic;
import java.time.LocalDate;
import java.util.ArrayList;

public class DTEstado {
	private Estado est;
	private LocalDate fecha;
	
	public DTEstado(Estado est, LocalDate fecha) {
		this.est = est;
		this.fecha = fecha;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	public Estado getEstado() {
		return this.est;
	}
	
	public void setFecha(LocalDate _fecha) {
		this.fecha = _fecha;
	}
	
	public void setEstado(Estado estado) {
		this.est = estado;
	}
}

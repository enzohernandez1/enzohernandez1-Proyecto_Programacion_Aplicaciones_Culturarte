package logica;
import java.time.*;

public class DTInfoAporte {
	private float monto;
	private LocalDate fechaAporte;
	private TipoRetorno retorno;
	private String titulo;
	
	DTInfoAporte(float _monto, LocalDate _fechaAporte, TipoRetorno _retorno, String _titulo){
		this.monto = _monto;
		this.fechaAporte = _fechaAporte;
		this.retorno = _retorno;
		this.titulo = _titulo;
	}
	
	//SETTERS
	public void setMonto(float _monto) {
		monto = _monto;
	}
	public void setfechaAporte(LocalDate _fechaAporte) {
		fechaAporte = _fechaAporte;
	}
	public void setretorno(TipoRetorno _retorno) {
		retorno = _retorno;
	}
	public void setTitulo(String _titulo) {
		titulo = _titulo;
	}
	
	//GETTERS
	public float getMonto() {
		return this.monto;
	}
	public LocalDate getFechaAporte() {
		return this.fechaAporte;
	}
	public TipoRetorno getRetorno() {
		return this.retorno;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
	
}

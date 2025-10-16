package logica;

import jakarta.persistence.*;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario comenusuario;
	
	@ManyToOne
	@JoinColumn(name = "propuesta_id")
	private Propuesta comenpropuesta;
	
	private String texto;
	
	public String getTexto() {
		return texto;
	}
	public Propuesta getPropuesta() {
		return comenpropuesta;
	}
	public Usuario getUsuario() {
		return comenusuario;
	}
	
	public void setText(String _texto) {
		this.texto = _texto;
	}
	
	public void setColaborador(Colaborador colab) {
		this.comenusuario = colab;
	}
	
	public void setPropuesta(Propuesta prop) {
		this.comenpropuesta = prop;
	}
}

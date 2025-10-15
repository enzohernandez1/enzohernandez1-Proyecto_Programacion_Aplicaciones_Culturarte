package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Proponente")
@Table(name="proponente")
public class Proponente extends Usuario{
	
	private String direccion;
	@Column(name="biografia",length=1000)
	private String biografia;
	private String linkWeb;
	
	@OneToMany(mappedBy = "proponente", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Propuesta> propuestas = new HashSet<>();
	
	public Proponente() {}
	
	public Proponente(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen, String direccion, String biografia, String linkWeb) {
		super(nickname, nombre, apellido, correoElec, fechaNac, imagen);
		this.direccion = direccion;
		this.biografia = biografia;
		this.linkWeb = linkWeb;
	}
	
	public Proponente(String nickname, String pwd, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen, String direccion, String biografia, String linkWeb) {
		super(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen);
		this.direccion = direccion;
		this.biografia = biografia;
		this.linkWeb = linkWeb;
	}

	// GETTERS
	public String getDireccion() {
		return this.direccion;
	}
	public String getBiografia() {
		return this.biografia;
	}
	public String getWeb() {
		return this.linkWeb;
	}
	
	public Propuesta buscarPropuesta(String titulo) {
		for(Propuesta prop: propuestas) {
			if(prop.getTitulo().equals(titulo)) {
				return prop;
			}
		}
		return null;
	}
	
	public void AgregarPropuesta(Propuesta p) {
		propuestas.add(p);
		p.setProponente(this); //para mantener la relacion en BD
	}
	
	public boolean tienePropuesta(Proponente p) {
		if(p.propuestas.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public List<DTPropPersona> dameTitulos(){
		List<DTPropPersona> resultado = new ArrayList(); //en el controlador la concateno con la del Controlador 
		for(Propuesta p: propuestas) {
			resultado.add(new DTPropPersona(this,p));
			}
		return resultado;
		}
	
}

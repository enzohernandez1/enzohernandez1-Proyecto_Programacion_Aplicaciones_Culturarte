package logica;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Colaborador")
@Table(name="colaborador")
public class Colaborador extends Usuario{

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)	
	private List<Aporte> aportes = new ArrayList<>();
	
	public Colaborador() {}
	
	public Colaborador(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		super(nickname, nombre, apellido, correoElec, fechaNac, imagen);
	}
	
	public Colaborador(String nickname, String pwd, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		super(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen);
	}
	
	public List<Aporte> getAporte(){
		return this.aportes;
	}
	
	//OPPERS DEL RESPALDO
	public void agregarAporte(Aporte p) {
		aportes.add(p);
		p.setColaborador(this);
	}
	
	public Boolean YaColaboro(String titulo) {
		for(Aporte a : aportes) {
			if(a.getTituloPropuesta().equals(titulo)) {
				return true;
			}
		}
		return false;
	}
	
	public List<DTInfoAporte> listarAportes(){ //de ArrayList lo paso a List
		List<DTInfoAporte> lista = new ArrayList<>();
		for(Aporte a : aportes) {
			lista.add(a.pasoDT());
		}
		return lista;
	}
	
	public DTColaborador getInfo() {
		DTColaborador colab = new DTColaborador();
		
		colab.setNickname(this.getNickname());
		colab.setNombre(this.getNombre());
		colab.setApellido(this.getApellido());
		colab.setCorreo(this.getCorreo());
		colab.setImagen(this.getImagen());
		
		return colab;
	}
}

package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DTColaborador extends DTUsuario {
	List <DTInfoAporte> misAportes = new ArrayList();
	
	public DTColaborador() {
		
	}
	
	public DTColaborador(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		super(nickname, nombre, apellido, correoElec, fechaNac, imagen);
	}

	public DTColaborador(String nickanme) {
		super(nickanme);
	}
	public DTColaborador(String nickname, String nombre, List<DTInfoAporte> _aportes) { //este constructor se usa en ventana CoalboracionPropuesta.
		super(nickname, nombre);
		this.misAportes = _aportes;
		
	}
	public DTColaborador(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen,ArrayList<Aporte> _misAportes) {
		super(nickname, nombre, apellido, correoElec, fechaNac, imagen);
	}
	
	//SETTERS
	public void setmisAportes(List<DTInfoAporte> _misAportes) {
		this.misAportes = _misAportes;
	}
	
}

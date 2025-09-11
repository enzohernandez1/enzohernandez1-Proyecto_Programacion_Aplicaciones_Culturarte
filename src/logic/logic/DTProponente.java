package logic;

import java.time.LocalDate;

public class DTProponente extends DTUsuario{

	private String direccion;
	private String biografia;
	private String linkWeb;
	
	
	public DTProponente(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen, String direccion, String biografia, String linkWeb) {
		super(nickname, nombre, apellido, correoElec, fechaNac, imagen);
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
}

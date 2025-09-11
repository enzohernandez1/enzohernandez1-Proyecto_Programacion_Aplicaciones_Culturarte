package logic;

import java.time.LocalDate;

public class DTUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String correoElec;
	private LocalDate fechaNac;
	private byte[] imagen;
	
	public DTUsuario() {}
	
	public DTUsuario(String _nickname, String _nombre){ //este constructor se usa en DTColaborador...
		this.nickname = _nickname;
		this.nombre = _nombre;
	}
	
	public DTUsuario(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElec = correoElec;
		this.fechaNac = fechaNac;
		this.imagen = imagen;
	}
	
	public DTUsuario(String nickname) {
        this.nickname = nickname;
    }
	
	// GETTERS
	public String getNickname() {
		return this.nickname;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public String getCorreo() {
		return this.correoElec;
	}
	public LocalDate getFecha() {
		return this.fechaNac;
	}
	public byte[] getImagen() {
		return this.imagen;
	}
	
	public void setNickname(String _nickname) {
		this.nickname  = _nickname;
	}
	public void setNombre(String _nombre) {
		this.nombre  = _nombre;
	}
	public void setApellido(String _apellido) {
		this.apellido  = _apellido;
	}
	public void setCorreo(String _correo) {
		this.correoElec  = _correo;
	}
	public void setFechaNac(LocalDate _FechaNac) {
		this.fechaNac  = _FechaNac;
	}
	public void setImagen(byte[] _imagen) {
		this.imagen  = _imagen;
	}
}

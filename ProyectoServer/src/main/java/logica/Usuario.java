package logica;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name="usuario")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_usuario",
discriminatorType=DiscriminatorType.STRING)
public abstract class Usuario {
	@Id
	private String nickname;
	private String pwd;
	@Column(unique = true)
	private String nombre;
	private String apellido;
	private String correoElec;
	private LocalDate fechaNac;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] imagen;
	@ManyToMany
	@JoinTable(
			name = "usuario_seguidores",
			joinColumns = @JoinColumn(name = "seguidor"),
			inverseJoinColumns = @JoinColumn(name = "usuario_seguido")
			)
	private Set<Usuario> seguidores = new HashSet<>();
	@ManyToMany
	@JoinTable(
			name = "usuario_propuestas_favoritas",
			joinColumns = @JoinColumn(name = "usuario_nickname"),
			inverseJoinColumns = @JoinColumn(name = "propuesta_id")
			)
	private Set<Propuesta> propuestasFavoritas = new HashSet<>();

	public Usuario() {}
	
	public Usuario(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElec = correoElec;
		this.fechaNac = fechaNac;
		this.imagen = imagen;
	}
	public Usuario(String nickname, String pwd, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
		this.nickname = nickname;
		this.pwd = pwd;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElec = correoElec;
		this.fechaNac = fechaNac;
		this.imagen = imagen;
		this.propuestasFavoritas = new HashSet<>();
	}

	// GETTERS
	public String getNickname() {
		return this.nickname;
	}
	public String getPwd() {
		return this.pwd;
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
	
	// SETTERS
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCorreo(String correo) {
		this.correoElec = correo;
	}
	public void setFecha(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}

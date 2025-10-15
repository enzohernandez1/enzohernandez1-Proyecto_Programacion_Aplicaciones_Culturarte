package logica;

public class DTPropPersona extends DTUsuario{
	private String titulo; //titulo de la propuesta
	private String nickname;	//nombre del proponente
	
	//GETTERS
	public String getTitulo() {
		return titulo;
	}
	public String getNickname() {
		return nickname;
	}
	
	
	public DTPropPersona(Usuario user, Propuesta prop) { //el mismo constructor se contruye con los getters.
		this.nickname = user.getNickname(); //se le hicieron los getters a la clase Usuario.
		this.titulo = prop.getTitulo(); //se le hicieron los getter a la clase Propuestas.
	}	
	
	public DTPropPersona(Usuario user) { //Para poder recibir en la lista solo Usuario sin Propuestas.
	    this.nickname = user.getNickname();
	    this.titulo = null;
	}
	
}

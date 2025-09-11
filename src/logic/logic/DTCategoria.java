package logic;



public class DTCategoria {
	private String nombre;
	private String nombrePadre; 

	public DTCategoria(String nombre, String nombrePadre) {
		this.nombre = nombre;
		this.nombrePadre = nombrePadre;
	}

	// GETTERS
	public String getNombre() {
		return nombre;
	}
	public String getNombrePadre() {
		return nombrePadre;
	}
	 
}

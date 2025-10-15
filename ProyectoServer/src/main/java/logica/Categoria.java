package logica;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	@ManyToOne
	private Categoria padre;

	@OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Categoria> subCategorias = new ArrayList<>();
	
	public Categoria() {

	}
	
	public Categoria(String nombre,Categoria padre) {
		// TODO Auto-generated constructor stub
        this.nombre = nombre;
        this.padre = padre;
        

	}
	public Categoria(String nombre2, Object categoriaPadre2) {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() { 
		return nombre; 
		}
    public Categoria getPadre() {
    	return padre;
    	}
    public List<Categoria> getSubCategorias() {
    	return subCategorias; 
    	}
	 
}

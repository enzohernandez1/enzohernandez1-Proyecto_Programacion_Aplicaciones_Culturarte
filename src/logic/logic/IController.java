package logic;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public abstract class IController {

	public IController() {}
	
	/*
	 * 
	auxiliares para la GUI creo
	//public abstract List<Estado> dameEstados(String titulo);
	//ArrayList<DTInfoAporte> dameAportes (String nickanme);
	
	//OPERACIONES conusltar propuestas por estado
	ArrayList<String> listarPropuestasEstado(Estado estado);
	 */
	public abstract boolean AltaProponente(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen, String direccion, String biografia, String linkWeb);
    public abstract boolean AltaColaborador(String nickname, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen);
    public abstract List<DTColaborador> listarColaboradores();
    public abstract List<DTProponente> listarProponentes();

    public abstract List<DTColaborador> getColaboradores();

    public abstract void AltaCategoria(String nombre, String nombrePadre) throws Exception;
    public abstract List<DTCategoria> getCategorias();

    public abstract List<DTPropuesta> consultarPropuestas(String nickname);
    //public abstract DTDetallePropuesta consultarPropuesta(String nombrePropuesta);
    public abstract void modificarPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, java.time.LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria, EstadoENUM estado);

    public abstract List<String> getColaboracionesDeColaborador(String nickname);
    public abstract DTDetalleAporte getDatosColaboracion(String nicknameColaborador, String tituloPropuesta);
    public abstract List<DTDetalleAporte> listarAportes();
    public abstract DTDetalleAporte obtenerAportePorId(String id);
    public abstract void cancelarAporte(String id);

    /*
  auxiliares para la GUI creo//public abstract List<Estado> dameEstados(String titulo);//ArrayList<DTInfoAporte> dameAportes (String nickanme);
  //OPERACIONES conusltar propuestas por estado
  ArrayList<String> listarPropuestasEstado(Estado estado);*/
    
    public abstract void AltaPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, java.time.LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria);
    public abstract void SeguirUsuario(String seguidor, String seguido) throws Exception;
    public abstract List<String> listarUsuarios() throws Exception;
    public abstract List<String> listarSeguimientos() throws Exception;
    public abstract void DejarDeSeguirUsuario(String seguidor, String seguido) throws Exception;
    public abstract List<String> getTitulosPropuestas();
    public abstract DTDetallePropuesta consultarPropuesta(String titulo);
	
	//REGISTRAR COLABORACION A PROPUESTA
	public abstract List<DTPropPersona> listarPropuestas();
	public abstract DTPropCompleto seleccionarPropuesta(String titulo);
	public abstract List<DTColaborador> listarColaboradores_RCB();
	public abstract DTColaborador seleccionarColaborador(String nickname, String titulo);
	public abstract void Registrar(TipoRetorno retorno, float monto, String nickname, String titulo) throws Exception; //el throw exception es para agarrar los errores en la GUI
	public abstract List<Estado> dameEstados(String titulo);
	public abstract List<DTInfoAporte> dameAportes(String nickname);
	//ver si dejarlas porque eran para POO
	public abstract void ConfirmarPropuesta(String titulo);
	public abstract void ConfirmarColaborador(String nickname);
	//auxiliar para la GUI
	public abstract DTColaborador BuscarColaborador_RCB(String nickname);
	public abstract Boolean PropuestaPermitida(String titulo);
	public abstract List<DTColaborador> buscarColaboradoresEnPropuesta(Long id);
	public abstract float calcularRecaudacion(Long id);
	
	public abstract List<String> listarPropuestasEstado(EstadoENUM estado);

	public abstract List<DTPropuesta> consultarPropuestasColaboradas(String usuario);
}



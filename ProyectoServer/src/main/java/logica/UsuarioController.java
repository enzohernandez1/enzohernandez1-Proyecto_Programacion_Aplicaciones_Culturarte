package logica;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class UsuarioController extends IController {

	private final UsuarioManager usrManager;
	
	public UsuarioController() {
		this.usrManager = new UsuarioManager();
	}
	
	public boolean AltaProponente(String nickname, String pwd, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen, String direccion, String biografia, String linkWeb) {
        DTProponente DTprop = new DTProponente(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen, direccion, biografia, linkWeb);
        if(usrManager.AltaProponente(DTprop)) {
            return true;
        }else {
            return false;
        }
    }

	 public boolean AltaColaborador(String nickname, String pwd, String nombre, String apellido, String correoElec, LocalDate fechaNac, byte[] imagen) {
         DTColaborador DTcol = new DTColaborador(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen);
         if(usrManager.AltaColaborador(DTcol)) {
             return true;
         }else {
             return false;
         }
    }
    @Override
    public void AltaCategoria(String nombre, String nombrePadre) {
        DTCategoria DTcat = new DTCategoria(nombre, nombrePadre);
        usrManager.AltaCategoria(DTcat);
    }
    @Override
    public List<DTCategoria> getCategorias() {
        return usrManager.getCategorias();
    }
	
    @Override
    public void AltaPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, java.time.LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria) {
    DTPropuesta DTProp = new DTPropuesta(nicknameProponente, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria);
    usrManager.AltaPropuesta(DTProp);
    }


    public List<DTProponente> listarProponentes() {
        return usrManager.listarProponentes();
    }
    @Override
    public List<DTColaborador> getColaboradores() {
        return usrManager.getColaboradores();
    }

    public List<DTColaborador> listarColaboradores() {
        return usrManager.listarColaboradores();
    }


    @Override
    public List<DTPropuesta> consultarPropuestas(String nickname) {
        return usrManager.consultarPropuestas(nickname);
    }


    @Override
    public DTDetallePropuesta consultarPropuesta(String nombrePropuesta) {
        return usrManager.consultarPropuesta(nombrePropuesta);
    }

    @Override
    public List<String> getTitulosPropuestas() {
        return usrManager.getTitulosPropuestas();
    }

    @Override
    public void modificarPropuesta(String nicknameProponente, String titulo, String descripcion, byte[] imagen, String lugar, java.time.LocalDate fecha, float precio, float montoNecesario, TipoRetorno tipoRetorno, String nombreCategoria, EstadoENUM estado) {
        DTPropuesta DTProp = new DTPropuesta(nicknameProponente, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria);
        usrManager.modificarPropuesta(DTProp, estado);
    }
@Override
    public List<DTColaborador> buscarColaboradoresEnPropuesta(Long id) {
        return usrManager.buscarColaboradoresEnPropuesta(id);
    }

    @Override
    public float calcularRecaudacion(Long id) {
        return usrManager.calcularRecaudacion(id);
    }
    @Override
    public void SeguirUsuario(String seguidor, String seguido) throws Exception {
        DTSeguidores dtSeg= new DTSeguidores( seguidor,seguido);
        usrManager.SeguirUsuario(dtSeg);
    }
    @Override
    public List<String> listarUsuarios() throws Exception {
        return usrManager.listarUsuarios();
    }


    @Override
    public List<String> listarSeguimientos() throws Exception {
        return usrManager.listarSeguimientos();
    }

    @Override
    public void DejarDeSeguirUsuario(String seguidor, String seguido) throws Exception {
        usrManager.DejarDeSeguirUsuario(seguidor, seguido);
    }

    @Override
    public List<String> getColaboracionesDeColaborador(String nickname) {
        return usrManager.getColaboracionesDeColaborador(nickname);
    }

    @Override
    public DTDetalleAporte getDatosColaboracion(String nicknameColaborador, String tituloPropuesta) {
        return usrManager.getDatosColaboracion(nicknameColaborador, tituloPropuesta);
    }

    @Override
    public List<DTDetalleAporte> listarAportes() {
        return usrManager.listarAportes();
    }

    @Override
    public DTDetalleAporte obtenerAportePorId(String id) {
        return usrManager.obtenerAportePorId(id);
    }

    @Override
    public void cancelarAporte(String id) {
        usrManager.cancelarAporte(id);
    }
//------------------------------------------------------------------------------------------------------------------------------------------
				//OPPERS DE REGISTRAR COLABORACION A PROPUESTA
//------------------------------------------------------------------------------------------------------------------------------------------
	public List<DTPropPersona> listarPropuestas(){
        return usrManager.listarPropuestas();
    }
	
	public List<DTColaborador> listarColaboradores_RCB(){
        return usrManager.listarColaboradores_RCB();
    }
	
	public Boolean PropuestaPermitida(String titulo) {
		return usrManager.PropuestaPermitida(titulo);
	}
	
	public List<Estado> dameEstados(String titulo){
		return usrManager.dameEstados(titulo);
	}
	
	public List<DTInfoAporte> dameAportes(String nickname){
		return usrManager.dameAportes(nickname);
	}
	
	public void ConfirmarPropuesta(String titulo) {
		usrManager.confirmarPropuesta(titulo);
	}
	
	public void ConfirmarColaborador(String nickname) {
		usrManager.confirmarColaborador(nickname);
	}
	
	public void Registrar(TipoRetorno retorno, float monto, String nickname, String titulo) throws Exception{
		 usrManager.Registrar(retorno, monto, nickname, titulo);
	}
	 
	public DTPropCompleto seleccionarPropuesta(String titulo) {
		return usrManager.seleccionarPropuesta(titulo);
	}
	
	public DTColaborador seleccionarColaborador(String nickname, String titulo) {
		return usrManager.seleccionarColaborador(nickname,titulo);
	}
	
	public DTColaborador BuscarColaborador_RCB(String nickname){
		return usrManager.BuscarColaborador_RCB(nickname);
	}
	
	public List<String> listarPropuestasEstado(EstadoENUM estado){
        return usrManager.listarPropuestasEstado(estado);
    }

	
	public List<DTPropuesta> consultarPropuestasColaboradas(String usuario) {
		return usrManager.consultarPropuestasColaboradas(usuario);
	}
	
	@Override
	public boolean evaluarPropuesta(String titulo, EstadoENUM nuevoEstado, String fechaCambio) {
		try {
			return usrManager.evaluarPropuesta(titulo, nuevoEstado, fechaCambio);
		} catch (Exception e) {
			return false;
		}
	}
	
}

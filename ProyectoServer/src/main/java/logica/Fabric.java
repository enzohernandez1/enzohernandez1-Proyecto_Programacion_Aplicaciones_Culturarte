package logica;

public class Fabric {

	public Fabric() {}

	public IController getUsrController() {
		return new UsuarioController();
	}
}

package GUI;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.DTDetalleAporte;
import logic.Fabric;
import logic.IController;

public class CancelarColaboracionPropuestaView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private javax.swing.JComboBox<String> comboColaboraciones;
	private javax.swing.JTextField txtNickname;
	private javax.swing.JTextField txtPropuesta;
	private javax.swing.JTextField txtFechaHora;
	private javax.swing.JTextField txtMonto;
	private javax.swing.JTextField txtTipoRetorno;
	private javax.swing.JButton btnCancelar;
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();

	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	/**
	 * Create the frame.
	 */
	public CancelarColaboracionPropuestaView() {
		setTitle("Cancelar Colaboracion a Propuesta");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		javax.swing.JLabel lblSeleccionar = new javax.swing.JLabel("Seleccionar ID de Aporte:");
		lblSeleccionar.setBounds(77, 60, 180, 20);
		contentPane.add(lblSeleccionar);

		comboColaboraciones = new javax.swing.JComboBox<>();
		comboColaboraciones.setBounds(307, 58, 220, 25);
		contentPane.add(comboColaboraciones);

		javax.swing.JLabel lblNickname = new javax.swing.JLabel("Nickname Colaborador:");
		lblNickname.setBounds(77, 130, 180, 20);
		contentPane.add(lblNickname);
		txtNickname = new javax.swing.JTextField();
		txtNickname.setBounds(307, 128, 220, 25);
		txtNickname.setEditable(false);
		contentPane.add(txtNickname);

		javax.swing.JLabel lblPropuesta = new javax.swing.JLabel("Propuesta:");
		lblPropuesta.setBounds(77, 204, 180, 20);
		contentPane.add(lblPropuesta);
		txtPropuesta = new javax.swing.JTextField();
		txtPropuesta.setBounds(307, 202, 220, 25);
		txtPropuesta.setEditable(false);
		contentPane.add(txtPropuesta);

		javax.swing.JLabel lblFecha = new javax.swing.JLabel("Fecha:");
		lblFecha.setBounds(77, 268, 180, 20);
		contentPane.add(lblFecha);
		txtFechaHora = new javax.swing.JTextField();
		txtFechaHora.setBounds(307, 266, 220, 25);
		txtFechaHora.setEditable(false);
		contentPane.add(txtFechaHora);

		javax.swing.JLabel lblMonto = new javax.swing.JLabel("Monto:");
		lblMonto.setBounds(77, 333, 180, 20);
		contentPane.add(lblMonto);
		txtMonto = new javax.swing.JTextField();
		txtMonto.setBounds(307, 331, 220, 25);
		txtMonto.setEditable(false);
		contentPane.add(txtMonto);

		javax.swing.JLabel lblTipoRetorno = new javax.swing.JLabel("Tipo de Retorno:");
		lblTipoRetorno.setBounds(77, 414, 180, 20);
		contentPane.add(lblTipoRetorno);
		txtTipoRetorno = new javax.swing.JTextField();
		txtTipoRetorno.setBounds(307, 412, 220, 25);
		txtTipoRetorno.setEditable(false);
		contentPane.add(txtTipoRetorno);

		btnCancelar = new javax.swing.JButton("Cancelar Colaboración");
		btnCancelar.setBounds(262, 523, 180, 30);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(452, 523, 124, 30);
		contentPane.add(btnNewButton);

	btnNewButton.addActionListener(e -> dispose());

	poblarColaboraciones();
	comboColaboraciones.addActionListener(e -> mostrarDetallesColaboracion());
	btnCancelar.addActionListener(e -> cancelarColaboracion());
	}

	private void poblarColaboraciones() {
		comboColaboraciones.removeAllItems();
		List<DTDetalleAporte> aportes = usrController.listarAportes();
		for (DTDetalleAporte aporte : aportes) {
			String display = aporte.getNicknameColaborador() + " - " + aporte.getNombrePropuesta();
			comboColaboraciones.addItem(display);
		}
	}

	private void mostrarDetallesColaboracion() {
		String seleccion = (String) comboColaboraciones.getSelectedItem();
		if (seleccion == null) return;
		// Buscar el aporte por el display string
		List<DTDetalleAporte> aportes = usrController.listarAportes();
		DTDetalleAporte aporte = null;
		for (DTDetalleAporte a : aportes) {
			String display = a.getNicknameColaborador() + " - " + a.getNombrePropuesta();
			if (display.equals(seleccion)) {
				aporte = a;
				break;
			}
		}
		if (aporte != null) {
			txtNickname.setText(aporte.getNicknameColaborador());
			txtPropuesta.setText(aporte.getNombrePropuesta());
			txtFechaHora.setText(aporte.getFecha() != null ? aporte.getFecha().toString() : "");
			txtMonto.setText(String.valueOf(aporte.getMonto()));
			txtTipoRetorno.setText(aporte.getTipoRetorno());
		} else {
			txtNickname.setText("");
			txtPropuesta.setText("");
			txtFechaHora.setText("");
			txtMonto.setText("");
			txtTipoRetorno.setText("");
		}
	}

	private void cancelarColaboracion() {
		String seleccion = (String) comboColaboraciones.getSelectedItem();
		if (seleccion == null) return;
		int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cancelar la colaboración?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
		if (confirm == javax.swing.JOptionPane.YES_OPTION) {
			usrController.cancelarAporte(seleccion);
			javax.swing.JOptionPane.showMessageDialog(this, "Colaboración cancelada exitosamente.");
			dispose();
		}
	}
}

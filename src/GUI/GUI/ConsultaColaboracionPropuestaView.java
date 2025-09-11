package GUI;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import logic.IController;
import logic.DTColaborador;
import logic.DTDetalleAporte;
import logic.Fabric;
import java.awt.Font;

public class ConsultaColaboracionPropuestaView extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboColaboradores;
	private JComboBox<String> comboColaboraciones;
	private JLabel lblNickname;
	private JLabel lblFechaHora;
	private JLabel lblMonto;
	private JLabel lblTipoRetorno;
	private JPanel panelDatos;
	private JLabel lblNick;
	private JLabel lblColaboraciones;
	private IController controller = new Fabric().getUsrController();

	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	/**
	 * Create the frame.
	 */
	public ConsultaColaboracionPropuestaView() {
		
		setTitle("Consulta de colaboración a propuesta");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboColaboradores = new JComboBox<>();
		comboColaboradores.removeAllItems();
		List<DTColaborador> colaboradores = controller.getColaboradores();
		for (DTColaborador colab : colaboradores) {
			comboColaboradores.addItem(colab.getNickname());
		}
		if (comboColaboradores.getItemCount() > 0) {
			comboColaboradores.setSelectedIndex(0);
		}

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(BorderFactory.createTitledBorder("Consulta de colaboración a propuesta"));
		panelPrincipal.setBounds(10, 30, 566, 483);
		panelPrincipal.setBackground(new java.awt.Color(250, 250, 255));
		contentPane.add(panelPrincipal);

		JLabel lblColaborador = new JLabel("Seleccionar Colaborador:");
		lblColaborador.setBounds(30, 35, 170, 25);
		panelPrincipal.add(lblColaborador);

	comboColaboradores.setSelectedIndex(-1);
	comboColaboradores.setBounds(345, 35, 200, 25);
	panelPrincipal.add(comboColaboradores);

	lblNick = new JLabel("Nickname:");
	lblNick.setBounds(30, 94, 170, 25);
	panelPrincipal.add(lblNick);

	lblNickname = new JLabel("");
	lblNickname.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNickname.setBounds(345, 94, 200, 25);
	panelPrincipal.add(lblNickname);

	lblColaboraciones = new JLabel("Colaboraciones:");
	lblColaboraciones.setBounds(30, 157, 170, 25);
	panelPrincipal.add(lblColaboraciones);

	comboColaboraciones = new JComboBox<>();
	comboColaboraciones.setSelectedIndex(-1);
	comboColaboraciones.setBounds(345, 157, 200, 25);
	panelPrincipal.add(comboColaboraciones);

	panelDatos = new JPanel();
	panelDatos.setLayout(null);
	panelDatos.setBorder(BorderFactory.createTitledBorder("Datos de la Colaboración"));
	panelDatos.setBackground(new java.awt.Color(245, 255, 245));
	panelDatos.setBounds(20, 241, 525, 170);
	panelPrincipal.add(panelDatos);

	lblNick.setVisible(false);
	lblColaboraciones.setVisible(false);
	comboColaboraciones.setVisible(false);
	panelDatos.setVisible(false);

	JLabel lblFecha = new JLabel("Fecha:");
	lblFecha.setBounds(30, 30, 120, 25);
	panelDatos.add(lblFecha);
	this.lblFechaHora = new JLabel("");
	this.lblFechaHora.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
	this.lblFechaHora.setBounds(160, 30, 200, 25);
	panelDatos.add(this.lblFechaHora);

	JLabel lblMonto = new JLabel("Monto:");
	lblMonto.setBounds(30, 65, 120, 25);
	panelDatos.add(lblMonto);
	this.lblMonto = new JLabel("");
	this.lblMonto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
	this.lblMonto.setBounds(160, 65, 200, 25);
	panelDatos.add(this.lblMonto);

	JLabel lblTipoRetorno = new JLabel("Tipo de Retorno:");
	lblTipoRetorno.setBounds(30, 100, 120, 25);
	panelDatos.add(lblTipoRetorno);
	this.lblTipoRetorno = new JLabel("");
	this.lblTipoRetorno.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
	this.lblTipoRetorno.setBounds(160, 100, 200, 25);
	panelDatos.add(this.lblTipoRetorno);

		JButton btnCerrar = new JButton("Atras");
		btnCerrar.setBounds(476, 523, 100, 30);
		contentPane.add(btnCerrar);
		btnCerrar.addActionListener(e -> dispose());

		comboColaboradores.addActionListener(e -> actualizarColaborador());
		comboColaboraciones.addActionListener(e -> actualizarColaboracion());

	actualizarColaborador();
	}


	private void actualizarColaborador() {
		String nickname = (String) comboColaboradores.getSelectedItem();
		boolean colaboradorSeleccionado = nickname != null && !nickname.isEmpty();
		lblNick.setVisible(colaboradorSeleccionado);
		lblColaboraciones.setVisible(colaboradorSeleccionado);
		comboColaboraciones.setVisible(colaboradorSeleccionado);
		panelDatos.setVisible(false);
		if (colaboradorSeleccionado) {
			lblNickname.setText(nickname);
			comboColaboraciones.removeAllItems();

			List<String> colaboraciones = controller.getColaboracionesDeColaborador(nickname);
			for (String propuesta : colaboraciones) {
				comboColaboraciones.addItem(propuesta);
			}
			comboColaboraciones.setSelectedIndex(-1);
			panelDatos.setVisible(false);
			lblFechaHora.setText("");
			lblMonto.setText("");
			lblTipoRetorno.setText("");
		} else {
			lblNickname.setText("");
			comboColaboraciones.removeAllItems();
			comboColaboraciones.setSelectedIndex(-1);
			lblFechaHora.setText("");
			lblMonto.setText("");
			lblTipoRetorno.setText("");
		}
	}

	private void actualizarColaboracion() {
		String nickname = (String) comboColaboradores.getSelectedItem();
		String colaboracion = (String) comboColaboraciones.getSelectedItem();
		boolean colaboracionSeleccionada = nickname != null && colaboracion != null && !colaboracion.isEmpty();
		panelDatos.setVisible(colaboracionSeleccionada);
		if (colaboracionSeleccionada) {
			DTDetalleAporte detalle = controller.getDatosColaboracion(nickname, colaboracion);
			   if (detalle != null) {
				   lblFechaHora.setText(detalle.getFecha().toString());
				   lblMonto.setText(String.valueOf(detalle.getMonto()));
				   lblTipoRetorno.setText(detalle.getTipoRetorno());
			   } else {
				   lblFechaHora.setText("");
				   lblMonto.setText("");
				   lblTipoRetorno.setText("");
			   }
		} else {
			lblFechaHora.setText("");
			lblMonto.setText("");
			lblTipoRetorno.setText("");
		}
	}
}

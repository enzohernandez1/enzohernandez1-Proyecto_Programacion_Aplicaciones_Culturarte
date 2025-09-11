package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.List;
import logic.EstadoENUM;
import logic.IController;
import logic.Fabric;
import logic.TipoRetorno;
import logic.DTCategoria;
import logic.DTDetallePropuesta;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ModificarDatosDePropuestaView extends JInternalFrame {
	private byte[] imagenSeleccionada = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbPropuestas;
	private JTextField txtTitulo;
	private JTextField txtLugar;
	private JSpinner spFecha;
	private JTextField txtPrecio;
	private JTextField txtMontoNecesario;
	private JComboBox<String> cmbTipoRetorno;
	private JComboBox<String> cmbCategoria;
	private JComboBox<EstadoENUM> cmbEstado;
	private JTextArea txtDescripcion;
	private JLabel lblImagen;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();

	// main eliminado, no se usa en JInternalFrame

	public ModificarDatosDePropuestaView() {
		setTitle("Modificar datos de Propuesta");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
	// setLocationRelativeTo no existe en JInternalFrame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeleccion = new JLabel("Seleccionar Propuesta:");
		lblSeleccion.setBounds(20, 20, 150, 25);
		contentPane.add(lblSeleccion);

		cmbPropuestas = new JComboBox<>();
		cmbPropuestas.setBounds(180, 20, 396, 25);
		contentPane.add(cmbPropuestas);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(255, 255, 255));
		panelDatos.setBounds(20, 60, 560, 443);
		panelDatos.setBorder(new TitledBorder("Datos de la Propuesta"));
		panelDatos.setVisible(false);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(30, 30, 100, 20);
		panelDatos.add(lblTitulo);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 30, 200, 22);
		txtTitulo.setEditable(false);
		panelDatos.add(txtTitulo);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(30, 70, 100, 20);
		panelDatos.add(lblDescripcion);
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		JScrollPane scrollDesc = new JScrollPane(txtDescripcion);
		scrollDesc.setBounds(120, 67, 400, 60);
		panelDatos.add(scrollDesc);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(30, 150, 100, 20);
		panelDatos.add(lblLugar);
		txtLugar = new JTextField();
		txtLugar.setBounds(120, 150, 200, 22);
		panelDatos.add(txtLugar);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(30, 190, 100, 20);
		panelDatos.add(lblFecha);
		spFecha = new JSpinner(new SpinnerDateModel());
		spFecha.setBounds(120, 190, 120, 22);
		spFecha.setEditor(new JSpinner.DateEditor(spFecha, "dd/MM/yyyy"));
		panelDatos.add(spFecha);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 230, 100, 20);
		panelDatos.add(lblPrecio);
		txtPrecio = new JTextField();
		txtPrecio.setBounds(120, 230, 120, 22);
		panelDatos.add(txtPrecio);

		JLabel lblMonto = new JLabel("Monto necesario:");
		lblMonto.setBounds(30, 270, 120, 20);
		panelDatos.add(lblMonto);
		txtMontoNecesario = new JTextField();
		txtMontoNecesario.setBounds(178, 270, 120, 22);
		panelDatos.add(txtMontoNecesario);

		JLabel lblTipoRetorno = new JLabel("Tipo de Retorno:");
		lblTipoRetorno.setBounds(30, 310, 120, 20);
		panelDatos.add(lblTipoRetorno);
		cmbTipoRetorno = new JComboBox<>();
		cmbTipoRetorno.setBounds(148, 309, 150, 22);
		panelDatos.add(cmbTipoRetorno);

		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(30, 350, 100, 20);
		panelDatos.add(lblCategoria);
		cmbCategoria = new JComboBox<>();
		cmbCategoria.setBounds(120, 349, 200, 22);
		panelDatos.add(cmbCategoria);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(30, 390, 100, 20);
		panelDatos.add(lblEstado);
		cmbEstado = new JComboBox<>(EstadoENUM.values());
		cmbEstado.setBounds(120, 389, 200, 22);
		panelDatos.add(cmbEstado);

		JLabel lblImagenTitulo = new JLabel("Imagen:");
		lblImagenTitulo.setBounds(385, 150, 100, 20);
		panelDatos.add(lblImagenTitulo);
		lblImagen = new JLabel();
		lblImagen.setBounds(385, 180, 120, 90);
		lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelDatos.add(lblImagen);
		JButton btnCargarImagen = new JButton("Cargar Imagen");
		btnCargarImagen.setBounds(385, 287, 120, 25);
		panelDatos.add(btnCargarImagen);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(456, 523, 120, 30);
		btnCancelar.setVisible(true);
		contentPane.add(btnCancelar);

		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setBounds(292, 523, 150, 30);
		btnGuardar.setVisible(false);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(e -> guardarCambios());
		btnCancelar.addActionListener(e -> {
			int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
			if(confirm == 0) {
				dispose();
			}
		});

		cmbPropuestas.addActionListener(e -> {
			String seleccion = (String) cmbPropuestas.getSelectedItem();
			if (seleccion != null && !seleccion.trim().isEmpty()) {
				cargarDatosPropuesta(seleccion);
				panelDatos.setVisible(true);
				btnGuardar.setVisible(true);
			} else {
				panelDatos.setVisible(false);
				btnGuardar.setVisible(false);
			}
		});
		btnCargarImagen.addActionListener(e -> cargarImagen());

		panelDatos.setVisible(false);
		btnGuardar.setVisible(false);
		btnCancelar.setVisible(true);
		cargarPropuestas();
		cargarCategorias();
		cargarTiposRetorno();
	}

	private void cargarDatosPropuesta(String propuesta) {
		DTDetallePropuesta detalle = usrController.consultarPropuesta(propuesta);

		txtTitulo.setText(detalle.getTitulo() != null ? detalle.getTitulo() : "");
		txtDescripcion.setText(detalle.getDescripcion() != null ? detalle.getDescripcion() : "");
		txtLugar.setText(detalle.getLugar() != null ? detalle.getLugar() : "");
		if (detalle.getFecha() != null) {
			spFecha.setValue(java.sql.Date.valueOf(detalle.getFecha()));
		}
		txtPrecio.setText(String.valueOf(detalle.getPrecio()));
		txtMontoNecesario.setText(String.valueOf(detalle.getMontoNecesario()));
		if (detalle.getTipoRetorno() != null) {
			cmbTipoRetorno.setSelectedItem(detalle.getTipoRetorno());
		} else {
			cmbTipoRetorno.setSelectedItem(null);
		}

		if (detalle.getTipoEspectaculo() != null) {
			cmbCategoria.setSelectedItem(detalle.getTipoEspectaculo());
		} else {
			cmbCategoria.setSelectedItem(null);
		}
		if (detalle.getEstado() != null) {
			cmbEstado.setSelectedItem(EstadoENUM.valueOf(detalle.getEstado()));
		} else {
			cmbEstado.setSelectedItem(null);
		}
		// lblImagen.setIcon(...) si tienes imagen
		imagenSeleccionada = detalle.getImagen();
		if (imagenSeleccionada != null) {
			java.awt.Image img = new ImageIcon(imagenSeleccionada).getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
			lblImagen.setIcon(new ImageIcon(img));
		} else {
			lblImagen.setIcon(null);
		}
	}

	private void guardarCambios() {
		String titulo = txtTitulo.getText().trim();
		String descripcion = txtDescripcion.getText().trim();
		String lugar = txtLugar.getText().trim();
		java.util.Date fechaDate = (java.util.Date) spFecha.getValue();
		java.time.LocalDate fecha = fechaDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		String precioStr = txtPrecio.getText().trim();
		String montoStr = txtMontoNecesario.getText().trim();
		String tipoRetornoStr = (String) cmbTipoRetorno.getSelectedItem();
		TipoRetorno tipoRetorno = null;
		if (tipoRetornoStr != null && !tipoRetornoStr.isEmpty()) {
			try {
				tipoRetorno = TipoRetorno.valueOf(tipoRetornoStr);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, "Tipo de retorno inválido.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		String nombreCategoria = (String) cmbCategoria.getSelectedItem();
		EstadoENUM estadoSeleccionado = (EstadoENUM) cmbEstado.getSelectedItem();

		String nicknameProponente = "";
	byte[] imagen = imagenSeleccionada;

		Float precio = null;
		Float montoNecesario = null;
		if (!precioStr.isEmpty()) {
			try {
				precio = Float.parseFloat(precioStr);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "El campo Precio debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (!montoStr.isEmpty()) {
			try {
				montoNecesario = Float.parseFloat(montoStr);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "El campo Monto necesario debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		usrController.modificarPropuesta(
			nicknameProponente,
			titulo.isEmpty() ? null : titulo,
			descripcion.isEmpty() ? null : descripcion,
			imagen,
			lugar.isEmpty() ? null : lugar,
			fecha,
			precio,
			montoNecesario,
			tipoRetorno,
			nombreCategoria,
			estadoSeleccionado
		);

		JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
		dispose();
	}

	private void cargarImagen() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			java.io.File file = fileChooser.getSelectedFile();
			try {
				java.nio.file.Path path = file.toPath();
				imagenSeleccionada = java.nio.file.Files.readAllBytes(path);
				ImageIcon icon = new ImageIcon(imagenSeleccionada);
				Image img = icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
				lblImagen.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cargarPropuestas() {
		cmbPropuestas.removeAllItems();
		cmbPropuestas.addItem("");
		List<String> propuestas = usrController.getTitulosPropuestas();
		for (String propuesta : propuestas) {
			cmbPropuestas.addItem(propuesta);
		}
		cmbPropuestas.setSelectedIndex(0);
	}

	private void cargarCategorias() {
		cmbCategoria.removeAllItems();
		List<DTCategoria> categorias = usrController.getCategorias();
		String categoriaActual = null;
		if (cmbPropuestas.getSelectedItem() != null) {
			DTDetallePropuesta detalle = usrController.consultarPropuesta((String) cmbPropuestas.getSelectedItem());
			categoriaActual = detalle != null ? detalle.getTipoEspectaculo() : null;
		}
		boolean encontrada = false;
		for (DTCategoria cat : categorias) {
			cmbCategoria.addItem(cat.getNombre());
			if (categoriaActual != null && cat.getNombre().equals(categoriaActual)) {
				encontrada = true;
			}
		}
		if (categoriaActual != null && !encontrada) {
			cmbCategoria.addItem(categoriaActual);
		}
    }

    private void cargarTiposRetorno() {
		cmbTipoRetorno.removeAllItems();
		String tipoRetornoActual = null;
		if (cmbPropuestas.getSelectedItem() != null) {
			DTDetallePropuesta detalle = usrController.consultarPropuesta((String) cmbPropuestas.getSelectedItem());
			tipoRetornoActual = detalle != null ? detalle.getTipoRetorno() : null;
		}
		boolean encontrada = false;
		for (TipoRetorno tipo : TipoRetorno.values()) {
			cmbTipoRetorno.addItem(tipo.name());
			if (tipoRetornoActual != null && tipo.name().equals(tipoRetornoActual)) {
				encontrada = true;
			}
		}
		if (tipoRetornoActual != null && !encontrada) {
			cmbTipoRetorno.addItem(tipoRetornoActual);
		}
    }
}

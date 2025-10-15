package GUI;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import logica.DTCategoria;
import logica.Fabric;
import logica.IController;
import logica.TipoRetorno;

public class AltaPropuestaView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtLugar;
	private JTextField txtPrecio;
	private JTextField txtMontoNecesario;

	private JLabel lblImagenPreview;
	private byte[] imagenSeleccionada;
	
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();
	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	/**
	 * Create the frame.
	 */
	public AltaPropuestaView() {
	setTitle("Alta Propuesta");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	JLabel lblProponente = new JLabel("Proponente*");
	lblProponente.setBounds(32, 60, 84, 12);
	contentPane.add(lblProponente);

	JComboBox<String> cmbProponentes = new JComboBox<>();
	cmbProponentes.setBounds(190, 57, 155, 18);
	List<logica.DTProponente> proponentes = usrController.listarProponentes();
	cmbProponentes.removeAllItems();
	for (logica.DTProponente prop : proponentes) {
		cmbProponentes.addItem(prop.getNickname());
	}
	contentPane.add(cmbProponentes);

		
		JLabel lblTipoEspectaculo = new JLabel("Tipo de Espectaculo*");
		lblTipoEspectaculo.setBounds(32, 100, 128, 12);
		contentPane.add(lblTipoEspectaculo);
		
	JComboBox<String> cmbTipoEspectaculo = new JComboBox<>();
	cmbTipoEspectaculo.setBounds(193, 96, 152, 20);
	List<DTCategoria> categorias = usrController.getCategorias();
	cmbTipoEspectaculo.removeAllItems();
	for (DTCategoria cat : categorias) {
		cmbTipoEspectaculo.addItem(cat.getNombre());
	}
	contentPane.add(cmbTipoEspectaculo);
		
		JLabel lblTitulo = new JLabel("Titulo*");
		lblTitulo.setBounds(32, 141, 44, 12);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(190, 138, 155, 18);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion*");
		lblDescripcion.setBounds(32, 189, 103, 12);
		contentPane.add(lblDescripcion);
		
		JTextArea textarDescripcion = new JTextArea();
		textarDescripcion.setLineWrap(true);
		textarDescripcion.setBounds(190, 183, 189, 77);
		contentPane.add(textarDescripcion);
		
		JLabel lblLugar = new JLabel("Lugar*");
		lblLugar.setBounds(32, 287, 44, 12);
		contentPane.add(lblLugar);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(190, 284, 155, 18);
		contentPane.add(txtLugar);
		txtLugar.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha*");
		lblFecha.setBounds(32, 329, 44, 12);
		contentPane.add(lblFecha);
		
	SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
	JSpinner spFecha = new JSpinner(dateModel);
	spFecha.setEditor(new JSpinner.DateEditor(spFecha, "dd/MM/yyyy"));
	spFecha.setBounds(190, 326, 97, 20);
	contentPane.add(spFecha);
		
		JLabel lblPrecio = new JLabel("Precio*");
		lblPrecio.setBounds(32, 376, 44, 12);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(190, 373, 155, 18);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblMontoNecesario = new JLabel("Monto Necesario*");
		lblMontoNecesario.setBounds(32, 424, 128, 12);
		contentPane.add(lblMontoNecesario);
		
		txtMontoNecesario = new JTextField();
		txtMontoNecesario.setBounds(190, 421, 155, 18);
		contentPane.add(txtMontoNecesario);
		txtMontoNecesario.setColumns(10);
		
		JLabel lblTipoRetorno = new JLabel("Tipo de Retorno*");
		lblTipoRetorno.setBounds(32, 472, 128, 12);
		contentPane.add(lblTipoRetorno);
		
	JComboBox<String> cmbTipoRetorno = new JComboBox<>();
	cmbTipoRetorno.setBounds(190, 468, 155, 20);
	cmbTipoRetorno.addItem("ENTRADA_GRATIS");
	cmbTipoRetorno.addItem("PORCENTAJE_GANANCIAS");
	cmbTipoRetorno.addItem("AMBOS_RETORNOS");
	contentPane.add(cmbTipoRetorno);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(465, 60, 67, 12);
		contentPane.add(lblImagen);

	lblImagenPreview = new JLabel("");
	lblImagenPreview.setOpaque(true);
	lblImagenPreview.setBackground(new Color(154, 153, 150));
	lblImagenPreview.setBounds(429, 90, 114, 106);
	contentPane.add(lblImagenPreview);

		JButton btnCargarImagen = new JButton("Cargar Imagen");
		btnCargarImagen.setBounds(429, 240, 119, 20);
		contentPane.add(btnCargarImagen);

		btnCargarImagen.addActionListener(e -> {
			JFileChooser selectorImagen = new JFileChooser();
			javax.swing.filechooser.FileFilter filterJpg = new javax.swing.filechooser.FileNameExtensionFilter("Imagenes (.JPG)", "jpg");
			selectorImagen.setFileFilter(filterJpg);
			selectorImagen.setAcceptAllFileFilterUsed(false);
			int result = selectorImagen.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				File img = selectorImagen.getSelectedFile();
				try {
					ImageIcon iconoOriginal = new ImageIcon(img.getAbsolutePath());
					Image imagenOriginal = iconoOriginal.getImage();
					Image imagenResized = imagenOriginal.getScaledInstance(114, 106, Image.SCALE_SMOOTH);
					lblImagenPreview.setIcon(new ImageIcon(imagenResized));
					BufferedImage buffered = new BufferedImage(114, 106, BufferedImage.TYPE_INT_RGB);
					java.awt.Graphics2D g2 = buffered.createGraphics();
					g2.drawImage(imagenResized, 0, 0, null);
					g2.dispose();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(buffered, "jpg", baos);
					imagenSeleccionada = baos.toByteArray();
				} catch (Exception ex) {
					javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar imagen: " + ex.getMessage());
					imagenSeleccionada = null;
				}
			}
		});
		
		JButton btnCargarPropuesta = new JButton("Crear Propuesta");
		btnCargarPropuesta.setBounds(396, 533, 152, 20);
		contentPane.add(btnCargarPropuesta);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(286, 533, 84, 20);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
					dispose();
				}
			}
		});


		btnCargarPropuesta.addActionListener(e -> {
			try {
				String nickname = (String) cmbProponentes.getSelectedItem();
				String titulo = txtTitulo.getText();
				String descripcion = textarDescripcion.getText();
				byte[] imagen = imagenSeleccionada; // Puede ser null si no se seleccionó una imagen
				String lugar = txtLugar.getText();
				Date date = (Date) spFecha.getValue();
				java.time.LocalDate fecha = new java.sql.Date(date.getTime()).toLocalDate();
				float precio = 0;
				float montoNecesario = 0;
				try {
					precio = Float.parseFloat(txtPrecio.getText());
					montoNecesario = Float.parseFloat(txtMontoNecesario.getText());
				} catch (NumberFormatException nfe) {
					javax.swing.JOptionPane.showMessageDialog(this, "Precio y Monto Necesario deben ser números válidos");
					return;
				}
				if (nickname.isEmpty() || titulo.isEmpty() || descripcion.isEmpty() || lugar.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos obligatorios deben estar completos");
					return;
				}
				String tipoRetornoStr = cmbTipoRetorno.getSelectedItem().toString();
				if (tipoRetornoStr.equals("ENTRADA_GRATIS")) tipoRetornoStr = "ENTRADA_GRATIS";
				else if (tipoRetornoStr.equals("PORCENTAJE_GANANCIAS")) tipoRetornoStr = "PORCENTAJE_GANANCIAS";
				else if (tipoRetornoStr.equals("AMBOS_RETORNOS")) tipoRetornoStr = "AMBOS_RETORNOS";
				TipoRetorno tipoRetorno = TipoRetorno.valueOf(tipoRetornoStr);
				String nombreCategoria = cmbTipoEspectaculo.getSelectedItem().toString();

				usrController.AltaPropuesta(nickname, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria);
				javax.swing.JOptionPane.showMessageDialog(this, "Propuesta creada exitosamente");
			} catch (Exception ex) {
				if (ex.getMessage() != null && ex.getMessage().contains("No result found for query")) {
					javax.swing.JOptionPane.showMessageDialog(this, "Error: El proponente seleccionado no existe.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
				} else {
					javax.swing.JOptionPane.showMessageDialog(this, "Error al crear propuesta: " + ex.getMessage());
				}
			}
		});
	}
}

package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import logica.Fabric;
import logica.IController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.image.BufferedImage;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPasswordField;

public class AltaPerfilView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTextField txtLinkWeb;
	private JTextArea taBiografia;
	private JComboBox cmbTipoUsuario;
	private JLabel lblImagen;
	
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();
	private JPasswordField txtPwd;
	private JPasswordField txtRePwd;
	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	
	private boolean verificarFecha(Date fechaSeleccionada) {
		Date fechaActual = new Date();
		Instant fechaAct = fechaActual.toInstant();
		Instant fechaSel = fechaSeleccionada.toInstant();
		
		if(fechaSel.isAfter(fechaAct)) {
			return false;
		}
		return true;
	}
	
	private boolean verificarCampos() {
		String seleccion = cmbTipoUsuario.getSelectedItem().toString();
		if(txtUsuario.getText().trim().isEmpty() || txtPwd.getText().trim().isEmpty() || txtRePwd.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if("Proponente".equals(seleccion)) { 
			if(txtDireccion.getText().trim().isEmpty() || txtLinkWeb.getText().trim().isEmpty() || taBiografia.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	private boolean verificarPwd() {
		if (txtPwd.getText().equals(txtRePwd.getText())) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
	private byte[] imagenABytes(Icon imag) throws Exception {
		BufferedImage img = new BufferedImage(
				lblImagen.getIcon().getIconWidth(),
				lblImagen.getIcon().getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graph = img.createGraphics();
		lblImagen.getIcon().paintIcon(null, graph, 0, 0);
		graph.dispose();
		
		
		ByteArrayOutputStream imgEnBytes = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", imgEnBytes);
		byte[] imagenEnBytes = imgEnBytes.toByteArray();
		return imagenEnBytes;
	}
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AltaPerfilView() throws ParseException {
	// setModalExclusionType no existe en JInternalFrame
	// Solo un setResizable, puedes dejarlo en true o false según prefieras
		setTitle("Crear perfil");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 600, 600);
	// setLocationRelativeTo no existe en JInternalFrame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		contentPane.setLayout(null);
		
		
		JPanel pnlUsuario = new JPanel();
		pnlUsuario.setBounds(20, 12, 572, 562);
		contentPane.add(pnlUsuario);
		pnlUsuario.setLayout(null);
		
		JPanel pnlProponente = new JPanel();
		pnlProponente.setBounds(92, 277, 299, 226);
		pnlUsuario.add(pnlProponente);
		pnlProponente.setLayout(null);
		pnlProponente.setVisible(false);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(124, 14, 50, 17);
		pnlUsuario.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(219, 12, 114, 21);
		pnlUsuario.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(122, 108, 53, 17);
		pnlUsuario.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(217, 106, 114, 21);
		pnlUsuario.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(122, 137, 54, 17);
		pnlUsuario.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(217, 135, 114, 21);
		pnlUsuario.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo electronico:");
		lblCorreo.setBounds(92, 168, 125, 17);
		pnlUsuario.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(217, 168, 114, 21);
		pnlUsuario.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de nacimiento:");
		lblFecha.setBounds(79, 207, 138, 17);
		pnlUsuario.add(lblFecha);

		SpinnerDateModel formato = new SpinnerDateModel();
		JSpinner spFecha = new JSpinner(formato); // REVISAR ENTRADA DE TECLADO
		spFecha.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!verificarFecha((Date) spFecha.getValue())) {
					Date fechaActual = new Date();
					JOptionPane.showMessageDialog(spFecha, "La fecha de nacimiento no puede ser posterior", "Error", JOptionPane.WARNING_MESSAGE);
					SwingUtilities.invokeLater(() ->{
						spFecha.setValue(fechaActual);
					});
				};
			}
		});
		spFecha.setBounds(217, 205, 116, 22);
		pnlUsuario.add(spFecha);
		spFecha.setEditor(new JSpinner.DateEditor(spFecha, "dd,MM,yyyy"));
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setBackground(new Color(255, 255, 255));
		cmbTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if("Proponente".equals((String)cmbTipoUsuario.getSelectedItem())) {
					pnlProponente.setVisible(true);
				}else {
					pnlProponente.setVisible(false);
				}
			}
		});
		cmbTipoUsuario.setBounds(217, 239, 114, 26);
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Colaborador", "Proponente"}));
		pnlUsuario.add(cmbTipoUsuario);
		
		lblImagen = new JLabel("");
		lblImagen.setOpaque(true);
		lblImagen.setBackground(new Color(154, 153, 150));
		lblImagen.setBounds(409, 39, 114, 106);
		pnlUsuario.add(lblImagen);
		
		JButton btnCargarImagen = new JButton("Cargar imagen");
		btnCargarImagen.setBackground(new Color(255, 255, 255));
		btnCargarImagen.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selectorImagen = new JFileChooser();
				FileFilter filterJpg = new FileNameExtensionFilter("Imagenes (.JPG)", "jpg");
				FileFilter filterPng = new FileNameExtensionFilter("Imagenes (.PNG)", "png");
				selectorImagen.setFileFilter(filterPng);
				selectorImagen.setFileFilter(filterJpg);
				selectorImagen.setAcceptAllFileFilterUsed(false);
				
				int result = selectorImagen.showOpenDialog(null);
				if(result == 0) { // IMAGEN SELECCIONADA
					// PROCESAMIENTO DE LA IMAGEN A UN ENTERO.
					File img = selectorImagen.getSelectedFile(); // REVISAR TOMA DE FORMATO PARA PASARLO A IMAGEN
					ImageIcon iconoOriginal = new ImageIcon(img.getAbsolutePath());
					Image imagenOriginal = iconoOriginal.getImage();
					Image imagenResized = imagenOriginal.getScaledInstance(114, 106, Image.SCALE_SMOOTH);
					
					lblImagen.setIcon(new ImageIcon(imagenResized));
				}
			}
		});
		btnCargarImagen.setBounds(409, 157, 114, 27);
		pnlUsuario.add(btnCargarImagen);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario:");
		lblTipoDeUsuario.setBounds(102, 244, 107, 17);
		pnlUsuario.add(lblTipoDeUsuario);
		

		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(26, 2, 60, 17);
		pnlProponente.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(91, 0, 120, 21);
		pnlProponente.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(26, 56, 78, 17);
		pnlProponente.add(lblBiografia);
		
	taBiografia = new JTextArea();
		taBiografia.setBackground(new Color(192, 191, 188));
		taBiografia.setBounds(12, 80, 275, 115);
		taBiografia.setLineWrap(true);
        taBiografia.getDocument().addDocumentListener(new DocumentListener() {
        private boolean modificando = false;
			public void insertUpdate(DocumentEvent e) {
				if(modificando) return;
				
				if(taBiografia.getText().length() >= 274) {
					modificando = true;
					JOptionPane.showMessageDialog(taBiografia, "La biografia solo puede tener 273 caracteres.", "Error", JOptionPane.WARNING_MESSAGE);
					String texto = taBiografia.getText().substring(0, 273); // BORRO SOBRANTE
					modificando = false;
					SwingUtilities.invokeLater(() -> {
						taBiografia.setText(texto);
					});
					
				}
			}
			
			public void removeUpdate(DocumentEvent e) {}
			public void changedUpdate(DocumentEvent e) {}
			
		});
		
		pnlProponente.add(taBiografia);
		
		JLabel lblLinkWeb = new JLabel("Sitio web:");
		lblLinkWeb.setBounds(26, 27, 60, 17);
		pnlProponente.add(lblLinkWeb);
		
		txtLinkWeb = new JTextField();
		txtLinkWeb.setColumns(10);
		txtLinkWeb.setBounds(91, 25, 120, 21);
		pnlProponente.add(txtLinkWeb);
		
		JLabel lblFotoPerfil = new JLabel("Foto de perfil (Opcional)");
		lblFotoPerfil.setBounds(388, 12, 147, 17);
		pnlUsuario.add(lblFotoPerfil);
		
		JButton btnDarAlta = new JButton("Dar de alta");
		btnDarAlta.setBackground(new Color(255, 255, 255));
		btnDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarFecha((Date)spFecha.getValue()) && verificarCampos() && verificarPwd()) {
					Date fechaNacimiento = (Date) spFecha.getValue();
					LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					byte[] imagenEnBytes = null;
					if(lblImagen.getIcon() != null){ // En caso que se coloque una imagen de perfil
						try {
							imagenEnBytes = imagenABytes(lblImagen.getIcon());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(cmbTipoUsuario.getSelectedItem() == "Proponente") {
						if(usrController.AltaProponente(txtUsuario.getText(), txtPwd.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac, imagenEnBytes, txtDireccion.getText(), taBiografia.getText(), txtLinkWeb.getText())) {
							JOptionPane.showMessageDialog(null, "Usuario creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}else { // ES COLABORADOR
						if(usrController.AltaColaborador(txtUsuario.getText(), txtPwd.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac, imagenEnBytes)) {
							JOptionPane.showMessageDialog(null, "Usuario creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnDarAlta.setBounds(285, 515, 106, 27);
		pnlUsuario.add(btnDarAlta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) { // EL USUARIO ESTA SEGURO DE CANCELAR
					dispose();
				}
			}
		});
		btnCancelar.setBounds(92, 515, 106, 27);
		pnlUsuario.add(btnCancelar);
		
		JLabel lblPwd = new JLabel("Contraseña:");
		lblPwd.setBounds(124, 45, 83, 17);
		pnlUsuario.add(lblPwd);
		
		JLabel lblRePwd = new JLabel("Confirmar contraseña:");
		lblRePwd.setBounds(69, 76, 138, 17);
		pnlUsuario.add(lblRePwd);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(219, 45, 114, 21);
		pnlUsuario.add(txtPwd);
		
		txtRePwd = new JPasswordField();
		txtRePwd.setBounds(219, 73, 114, 21);
		pnlUsuario.add(txtRePwd);
	}
}
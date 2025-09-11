package GUI;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logic.DTColaborador;
import logic.DTProponente;
import logic.Fabric;
import logic.IController;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Dialog.ModalExclusionType;

public class ConsultarProponenteView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ConsultarProponenteView frame;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblFotoPerfil;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFecha;
	private JButton btnVerPropuestas;
	private JTextArea taBiografia;
	private JLabel lblImagen;
	
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();
	private JTextField txtDireccion;
	private JTextField txtWeb;
	
	private void cargarDatos() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<DTProponente> proponentes = usrController.listarProponentes();
		for (DTProponente proponente : proponentes) {
			model.addRow(new Object[] {
					proponente.getNickname(), 
					proponente.getNombre(), 
					proponente.getApellido(), 
					proponente.getCorreo(), 
					proponente.getFecha(),
					proponente.getImagen(),
					proponente.getDireccion(),
					proponente.getWeb(),
					proponente.getBiografia()
					});
		}
	}
	
	public void iniciar() {
		setVisible(true);
		cargarDatos();
	}
	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	/**
	 * Create the frame.
	 */
	public ConsultarProponenteView() {
	// setModalExclusionType no existe en JInternalFrame
		setTitle("Consultar proponente");
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
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel model = table.getModel(); // GUARDO MODELO PARA PODER USAR LA INFORMACION QUE NO SE MUESTRA
				int row = table.rowAtPoint(e.getPoint());
				
				if(table.getValueAt(row, 0) == null) return; // LA FILA SELECCIONADA ESTA VACIA
				txtUsuario.setText(table.getValueAt(row, 0).toString());
				txtNombre.setText(table.getValueAt(row, 1).toString());
				txtApellido.setText(table.getValueAt(row, 2).toString());
				txtCorreo.setText(table.getValueAt(row, 3).toString());
				txtFecha.setText(table.getValueAt(row, 4).toString());
				if(model.getValueAt(row,5) == null) {
					lblImagen.setIcon(null);
				}else {
					byte[] img = (byte[]) model.getValueAt(row, 5);
					ImageIcon perfil = new ImageIcon(img);
					lblImagen.setIcon(perfil);
				}
				// COLUMNA 5 ES LA IMAGEN AGREGAR A FUTURO...
				txtDireccion.setText(model.getValueAt(row, 6).toString());
				txtWeb.setText(model.getValueAt(row, 7).toString());
				taBiografia.setText(model.getValueAt(row, 8).toString());
				
				btnVerPropuestas.setEnabled(true); // ACTIVO EL BOTON PARA VER COLABORACIONES
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {"Usuario", "Nombre", "Apellido", "Correo electronico", "Fecha de nacimiento", "Imagen", "Direccion", "Web", "Biografia"})
			{
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(12, 12, 275, 10000);
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(8));
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(7));
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(6));
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(5));

		for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150); // AJUSTO TAMANO DE LA COLUMNA
        }
		
		JScrollPane scrollPane = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
            );
		scrollPane.setBounds(12, 12, 275, 507);
		contentPane.add(scrollPane);
		
		lblImagen = new JLabel("");
		lblImagen.setOpaque(true);
		lblImagen.setBackground(new Color(154, 153, 150));
		lblImagen.setBounds(388, 41, 114, 106);
		contentPane.add(lblImagen);
		
		lblFotoPerfil = new JLabel("Foto de perfil");
		lblFotoPerfil.setBounds(401, 12, 91, 17);
		contentPane.add(lblFotoPerfil);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(325, 183, 50, 17);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(388, 181, 114, 21);
		contentPane.add(txtUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(388, 212, 114, 21);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(325, 214, 53, 17);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(321, 247, 54, 17);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(new Color(255, 255, 255));
		txtApellido.setEditable(false);
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(388, 245, 114, 21);
		contentPane.add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(255, 255, 255));
		txtCorreo.setEditable(false);
		txtCorreo.setEnabled(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(388, 276, 114, 21);
		contentPane.add(txtCorreo);
		
		JLabel lblCorreo = new JLabel("Email:");
		lblCorreo.setBounds(325, 278, 50, 17);
		contentPane.add(lblCorreo);
		
		JLabel lblFecha = new JLabel("Nacimiento:");
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFecha.setBounds(312, 294, 82, 38);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBackground(new Color(255, 255, 255));
		txtFecha.setEditable(false);
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(388, 303, 114, 21);
		contentPane.add(txtFecha);
		
		btnVerPropuestas = new JButton("Ver propuestas");
		btnVerPropuestas.setEnabled(false);
		btnVerPropuestas.setBackground(new Color(255, 255, 255));
		btnVerPropuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProponentePropuestaView proponentePropuesta = new ProponentePropuestaView(null, txtUsuario.getText(),usrController);
				proponentePropuesta.inicio();
				// ACTIVO VENTANA DE PROPUESTAS
			}
		});
		btnVerPropuestas.setBounds(299, 533, 281, 27);
		contentPane.add(btnVerPropuestas);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(388, 336, 114, 21);
		contentPane.add(txtDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDireccion.setBounds(315, 327, 63, 38);
		contentPane.add(lblDireccion);
		
		txtWeb = new JTextField();
		txtWeb.setEnabled(false);
		txtWeb.setEditable(false);
		txtWeb.setColumns(10);
		txtWeb.setBackground(Color.WHITE);
		txtWeb.setBounds(388, 370, 114, 21);
		contentPane.add(txtWeb);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setFont(new Font("Dialog", Font.BOLD, 12));
		lblWeb.setBounds(325, 361, 30, 38);
		contentPane.add(lblWeb);
		
		taBiografia = new JTextArea();
		taBiografia.setEnabled(false);
	    taBiografia.setText("Biografia");
		taBiografia.setBackground(new Color(192, 191, 188));
		taBiografia.setBounds(299, 404, 275, 115); 
		taBiografia.setLineWrap(true);
        taBiografia.getDocument().addDocumentListener(new DocumentListener() {
        private boolean modificando = false;
			public void insertUpdate(DocumentEvent e) {
				if(modificando) return;
				
				if(taBiografia.getText().length() >= 1000) {
					modificando = true;
					JOptionPane.showMessageDialog(taBiografia, "La biografia solo puede tener 1000 caracteres.", "Error", JOptionPane.WARNING_MESSAGE);
					String texto = taBiografia.getText().substring(0, 999); // BORRO SOBRANTE
					modificando = false;
					SwingUtilities.invokeLater(() -> {
						taBiografia.setText(texto);
					});
					
				}
			}
			
			public void removeUpdate(DocumentEvent e) {}
			public void changedUpdate(DocumentEvent e) {}
			
		});
		
		
		
		contentPane.add(taBiografia);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 533, 120, 27);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
					dispose();
				}
			}
		});
		contentPane.add(btnCancelar);
	}
}

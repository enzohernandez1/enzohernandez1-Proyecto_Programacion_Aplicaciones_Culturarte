package GUI;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logica.DTColaborador;
import logica.Fabric;
import logica.IController;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class ConsultarColaboradorView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ConsultarColaboradorView frame;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblFotoPerfil;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFecha;
	private JButton btnVerColaboraciones;
	private JLabel lblImagen;
	
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();
	
	private void cargarDatos() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<DTColaborador> colaboradores = usrController.listarColaboradores();
		for (DTColaborador colaborador : colaboradores) {
			model.addRow(new Object[] {
					colaborador.getNickname(), 
					colaborador.getNombre(), 
					colaborador.getApellido(), 
					colaborador.getCorreo(), 
					colaborador.getFecha(),
					colaborador.getImagen()
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
	public ConsultarColaboradorView() {
	setTitle("Consultar colaborador");
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setResizable(true);
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	setBounds(0, 0, 600, 600);
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
				btnVerColaboraciones.setEnabled(true); // ACTIVO EL BOTON PARA VER COLABORACIONES
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {"Usuario", "Nombre", "Apellido", "Correo electronico", "Fecha de nacimiento", "Imagen"})
			{
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			});
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(5));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(12, 12, 275, 10000);
		
		for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150); // AJUSTO TAMANO DE LA COLUMNA
        }
		
		JScrollPane scrollPane = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
            );
		scrollPane.setBounds(12, 12, 275, 511);
		contentPane.add(scrollPane);
		
		lblImagen = new JLabel("");
		lblImagen.setOpaque(true);
		lblImagen.setBackground(new Color(154, 153, 150));
		lblImagen.setBounds(388, 41, 114, 106);
		contentPane.add(lblImagen);
		
		lblFotoPerfil = new JLabel("Foto de perfil");
		lblFotoPerfil.setBounds(401, 12, 91, 17);
		contentPane.add(lblFotoPerfil);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(416, 184, 50, 17);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(388, 202, 114, 21);
		contentPane.add(txtUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(388, 251, 114, 21);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(413, 235, 53, 17);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(413, 284, 54, 17);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(new Color(255, 255, 255));
		txtApellido.setEditable(false);
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(385, 301, 117, 21);
		contentPane.add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(255, 255, 255));
		txtCorreo.setEditable(false);
		txtCorreo.setEnabled(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(388, 351, 114, 21);
		contentPane.add(txtCorreo);
		
		JLabel lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setBounds(388, 334, 125, 17);
		contentPane.add(lblCorreo);
		
		JLabel lblFecha = new JLabel("Fecha de nacimiento");
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFecha.setBounds(385, 380, 128, 17);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBackground(new Color(255, 255, 255));
		txtFecha.setEditable(false);
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(383, 399, 119, 21);
		contentPane.add(txtFecha);
		
		btnVerColaboraciones = new JButton("Ver colaboraciones");
		btnVerColaboraciones.setEnabled(false);
		btnVerColaboraciones.setBackground(new Color(255, 255, 255));
		btnVerColaboraciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ColaboradorColaboracionesView verColaboraciones = new ColaboradorColaboracionesView(null, usrController,txtUsuario.getText());
				verColaboraciones.iniciar();
			}
		});
		btnVerColaboraciones.setBounds(293, 496, 281, 27);
		contentPane.add(btnVerColaboraciones);

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

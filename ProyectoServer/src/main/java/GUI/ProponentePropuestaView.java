package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.IController;
import logica.DTColaborador;
import logica.DTPropuesta;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;

public class ProponentePropuestaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String usuario;
	private IController controller;
	private JComboBox<String> cmbColaboradores;

	private void cargarDatos(){
		List<DTPropuesta> propuestas = controller.consultarPropuestas(usuario);
		if(propuestas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay propuestas de parte del proponente", "AVISO", JOptionPane.WARNING_MESSAGE);
		}else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(DTPropuesta prop : propuestas) {
				List<DTColaborador> colaboradores = controller.buscarColaboradoresEnPropuesta(prop.getId());
				cmbColaboradores.removeAllItems(); // LIMPIO COMBO BOX PARA EVITAR ERRORES
				for(DTColaborador col : colaboradores) {
					cmbColaboradores.addItem(col.getNickname());
				}
				model.addRow(new Object[] {
						prop.getTitulo(),
						cmbColaboradores,
						controller.calcularRecaudacion(prop.getId()),
						prop.getEstado().getEstado().name()
				});
			}
		}
	}
	
	public void inicio() {
		cargarDatos();
		setVisible(true);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProponentePropuestaView dialog = new ProponentePropuestaView(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProponentePropuestaView(JFrame padre, String usuario, IController controller) {
		super(padre, "Colaboraciones", true);
		this.usuario = usuario;
		this.controller = controller;
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 442, 233);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 233, 442, 39);
			buttonPane.setBorder(new LineBorder(new Color(222, 221, 218)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setBackground(new Color(255, 255, 255));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
				buttonPane.add(btnSalir);
			
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setRowSelectionAllowed(true);
				table.setColumnSelectionAllowed(false);
				table.setCellSelectionEnabled(false);
				table.setModel(new DefaultTableModel(
					    new Object[][] {,},
					    new String[] {"Propuesta", "Colaboradores","Dinero recaudado", "Estado actual"})
					{
					    public boolean isCellEditable(int row, int column) {
					        return column == 1;
					    }
					});
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setBounds(0, 0, 275, 10000);
				
				
				for (int i = 0; i < table.getColumnCount(); i++) {
		            table.getColumnModel().getColumn(i).setPreferredWidth(112); // AJUSTO TAMANO DE LA COLUMNA
		        }
				contentPanel.setLayout(new BorderLayout(0, 0));

				JScrollPane scrollPane = new JScrollPane(
		                table,
		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		            );
				scrollPane.setBounds(20, 20, 275, 548);
				contentPanel.add(scrollPane);
				
				cmbColaboradores = new JComboBox<>();
				table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cmbColaboradores)); 

			}
		}
	}

}
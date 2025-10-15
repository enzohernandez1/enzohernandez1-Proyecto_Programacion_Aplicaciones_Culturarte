package GUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import logica.DTPropuesta;
import logica.EstadoENUM;
import logica.IController;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ColaboradorColaboracionesView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private IController controller;
	private String usuario;

	/**
	 * Launch the application.
	 */
	private void cargarDatos() {
		List<DTPropuesta> propuestas = controller.consultarPropuestasColaboradas(usuario);
		if(propuestas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay colaboraciones de parte del colaborador", "AVISO", JOptionPane.WARNING_MESSAGE);
		}else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(DTPropuesta prop : propuestas) {
				model.addRow(new Object[]{
					prop.getTitulo(),
					prop.getNicknameProponente(),
					controller.calcularRecaudacion(prop.getId()),
					prop.getEstado().getEstado().name()
				});
			}
		}
	}
	
	public void iniciar() {
		cargarDatos();
		setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public ColaboradorColaboracionesView(JFrame padre, IController controller, String usuario) {
		super(padre, "Colaboraciones", true);
		this.controller = controller;
		this.usuario = usuario;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(222, 221, 218)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
			}
			{
				
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setRowSelectionAllowed(true);
				table.setColumnSelectionAllowed(false);
				table.setCellSelectionEnabled(false);
				table.setModel(new DefaultTableModel(
					    new Object[][] {},
					    new String[] {"Propuesta", "Proponente", "Dinero recaudado", "Estado actual"})
					{
					    public boolean isCellEditable(int row, int column) {
					        return false;
					    }
					});
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setBounds(12, 12, 275, 10000);
				
				
				for (int i = 0; i < table.getColumnCount(); i++) {
		            table.getColumnModel().getColumn(i).setPreferredWidth(112); // AJUSTO TAMANO DE LA COLUMNA
		        }
				


				JScrollPane scrollPane = new JScrollPane(
		                table,
		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		            );
				scrollPane.setBounds(12, 12, 275, 548);
				contentPanel.add(scrollPane);
			}
		}
	}

}

//clases(Datatypes, enums, controlador)
package GUI;


import logic.DTDetallePropuesta;
import logic.DTEstado;
import logic.Estado;
import logic.EstadoENUM;
import logic.Fabric;
import logic.IController;
import logic.TipoRetorno;

//librerias
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.List;	

public class ConsultarPropPorEstado extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IController controlador;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JLabel lblNewLabel_2;
	private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_6;
	private JLabel lblNewLabel_12;
	private JTextField textField_8;
	private JLabel lblNewLabel_13;
	private JTextField textField_9;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblImagen;

	
	public ConsultarPropPorEstado() {
		super("Consultar propuestas por estados", false, false, false, false);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TITULO
		lblNewLabel = new JLabel("Consultar propuestas por estados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(103, 11, 345, 29);
		contentPane.add(lblNewLabel);
		
		//SELECCCION DE ESTADO
		lblNewLabel_1 = new JLabel("Seleccione un estado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(26, 64, 191, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox  = new JComboBox<>(EstadoENUM.values()); //el .values ya me los ingresa
		comboBox.setBounds(26, 79, 191, 22);
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(-1);
		
		DefaultListModel<String> modeloColaboradores = new DefaultListModel<>();
		JList<String> listaColaboradores = new JList<>(modeloColaboradores);
		JScrollPane scrollColaboradores = new JScrollPane(listaColaboradores);
	    scrollColaboradores.setBounds(26, 392, 191, 158);
		contentPane.add(scrollColaboradores);
		
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------TABLA DE PROPUESTAS DE ESTADO----------------------------------------------------------------
		DefaultTableModel model0 = new DefaultTableModel() {
			
			//ESTO PARA QUE NO EDITEN LOS CAMPOS DE LA TABLA
		    public boolean isCellEditable(int row, int column) {
		        return false; // bloquea la edición
		    }
		};
		
		model0.addColumn("Titulo");
		
		table = new JTable(model0);
		table.getTableHeader().setReorderingAllowed(false); //para que no muevan las columnas de lugar
		table.getTableHeader().setResizingAllowed(false); //para no redimensionar las columnas
		
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(26, 129, 191, 227);
		contentPane.setLayout(null);  
		contentPane.add(scrollPane1);
		
		
		lblNewLabel_2 = new JLabel("Propuestas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(26, 112, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Colaboradores: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(26, 367, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Titulo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(241, 93, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(241, 110, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Proponente:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(241, 135, 97, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 154, 139, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de espetaculo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(241, 185, 122, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(241, 200, 139, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblNewLabel_7 = new JLabel("Lugar:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(400, 185, 83, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(400, 200, 161, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(241, 225, 109, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(241, 242, 139, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha publicacion:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(400, 225, 109, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(400, 242, 161, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		JLabel lblNewLabel_10 = new JLabel("Precio:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(241, 271, 109, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Monto necesario:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(400, 271, 110, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(241, 287, 139, 20);
		contentPane.add(textField_7);
		textField_7.setEditable(false);
		
		textField_6 = new JTextField();
		textField_6.setBounds(400, 287, 161, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		lblNewLabel_12 = new JLabel("Monto recaudado:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(241, 318, 109, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_8 = new JTextField();
		textField_8.setBounds(241, 336, 139, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		
		lblNewLabel_13 = new JLabel("Estado:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(399, 318, 110, 14);
		contentPane.add(lblNewLabel_13);
		
		textField_9 = new JTextField();
		textField_9.setBounds(400, 336, 161, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		textField_9.setEditable(false);
		
		lblNewLabel_14 = new JLabel("Descripcion:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(241, 367, 139, 14);
		contentPane.add(lblNewLabel_14);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(241, 387, 320, 163);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		table.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
		        // Obtener el título de la propuesta de la fila seleccionada (columna 0)
		        String tituloSeleccionado = (String) model0.getValueAt(table.getSelectedRow(), 0);

		        // Consultar la propuesta
		        DTDetallePropuesta propuesta = usrController.consultarPropuesta(tituloSeleccionado);
		        textField.setText(propuesta.getTitulo());
		        textField_1.setText(propuesta.getProponente());
		        textField_2.setText(propuesta.getTipoEspectaculo());
		        textField_3.setText(propuesta.getLugar());
		        textField_4.setText(propuesta.getFecha());
		        textField_5.setText(propuesta.getFechaPublicacion());
		        textField_7.setText(String.valueOf(propuesta.getPrecio()));
		        textField_6.setText(String.valueOf(propuesta.getMontoNecesario())); 
		        textField_8.setText(String.valueOf(propuesta.getMontoRecaudado()));
		        textField_9.setText(propuesta.getEstado());
		        textArea.setText(propuesta.getDescripcion());
		        
		        lblNewLabel_15 = new JLabel("Imagen Propuesta");
		        lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		        lblNewLabel_15.setBounds(425, 49, 109, 14);
		        contentPane.add(lblNewLabel_15);
		        
		        lblImagen = new JLabel("");
		        lblImagen.setOpaque(true);
		        lblImagen.setBackground(new Color(154, 153, 150));
		        lblImagen.setBounds(411, 64, 140, 120);
		        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		        contentPane.add(lblImagen);
		        
		        //IMAGEN
		        byte[] imagedata = propuesta.getImagen();
				  if (imagedata != null) {
					  lblImagen.setIcon(new javax.swing.ImageIcon(imagedata));
				  } else {
					  lblImagen.setIcon(null);
				  }
				  
				 //COLABORADOR
				  modeloColaboradores.clear();
				  for (String colaborador : propuesta.getColaboradores()) {
					  modeloColaboradores.addElement(colaborador);
				  }
		    }
});
		

		//listener en la seleccion del estado para cargar los titulos de la propuesta.
		comboBox.addActionListener(e -> {
			EstadoENUM estadoSeleccionado = (EstadoENUM) comboBox.getSelectedItem();  //sacamos el estado que eligio en el combobox
			model0.setRowCount(0);    //borramos todo lo que tenga la tabla
			List<String> titulos = usrController.listarPropuestasEstado(estadoSeleccionado);
				for(String titulo : titulos) {    //mostramos los titulos en la tabla 
					model0.addRow(new Object[] {titulo});
				}
		});

		// Botón Cancelar/Atrás
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(470, 560, 100, 22);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.addActionListener(e -> dispose());
		contentPane.add(btnCancelar);
	}
}
		
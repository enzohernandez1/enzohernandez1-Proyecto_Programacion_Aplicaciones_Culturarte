package GUI;
import java.awt.EventQueue;

import logica.Fabric;
import logica.IController;
import logica.DTDetallePropuesta;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarPropuestaView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// main eliminado, no se usa en JInternalFrame

	/**
	 * Create the frame.
	 */
       public ConsultarPropuestaView() {
    	   IController controller = new Fabric().getUsrController();
       	setTitle("Consultar Propuesta");
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

   	   JPanel panelSeleccion = new JPanel();
   	   panelSeleccion.setBounds(10, 10, 566, 46);
   	   contentPane.add(panelSeleccion);
   	   panelSeleccion.setLayout(null);

   	   JLabel lblPropuesta = new JLabel("Propuesta:");
   	   lblPropuesta.setBounds(10, 10, 95, 26);
   	   panelSeleccion.add(lblPropuesta);

   	   JComboBox<String> cmbPropuestas = new JComboBox<>();
   	   cmbPropuestas.setBounds(115, 10, 441, 26);
   	   panelSeleccion.add(cmbPropuestas);

   	   java.util.List<String> titulos = controller.getTitulosPropuestas();
   	   for (String titulo : titulos) {
   		   cmbPropuestas.addItem(titulo);
   	   }

   	   JPanel panelDatos = new JPanel();
   	   panelDatos.setBounds(10, 66, 566, 448);
   	   panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(192,192,192)), "Datos de la Propuesta"));
   	   panelDatos.setLayout(null);
   	   panelDatos.setVisible(false);

		// Botón Cancelar siempre visible
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(420, 531, 154, 29);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Está seguro de salir?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
					dispose();
				}
			}
		});
		contentPane.add(btnCancelar);
   	   contentPane.add(panelDatos);

   	   JLabel lblTitulo = new JLabel("Titulo:");
   	   lblTitulo.setBounds(30, 30, 105, 16);
   	   panelDatos.add(lblTitulo);
   	   JTextField txtTitulo = new JTextField();
   	   txtTitulo.setBounds(150, 28, 180, 20);
   	   txtTitulo.setEditable(false);
   	   panelDatos.add(txtTitulo);

   	   JLabel lblProponente = new JLabel("Proponente:");
   	   lblProponente.setBounds(30, 55, 105, 16);
   	   panelDatos.add(lblProponente);
   	   JTextField txtProponente = new JTextField();
   	   txtProponente.setBounds(150, 53, 180, 20);
   	   txtProponente.setEditable(false);
   	   panelDatos.add(txtProponente);

   	   JLabel lblTipoEspectaculo = new JLabel("Tipo Espectaculo:");
   	   lblTipoEspectaculo.setBounds(30, 80, 126, 16);
   	   panelDatos.add(lblTipoEspectaculo);
   	   JTextField txtTipoEspectaculo = new JTextField();
   	   txtTipoEspectaculo.setBounds(150, 78, 180, 20);
   	   txtTipoEspectaculo.setEditable(false);
   	   panelDatos.add(txtTipoEspectaculo);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(30, 110, 105, 16);
		panelDatos.add(lblLugar);
		JTextField txtLugar = new JTextField();
		txtLugar.setBounds(150, 108, 180, 20);
		txtLugar.setEditable(false);
		panelDatos.add(txtLugar);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(30, 140, 105, 16);
		panelDatos.add(lblFecha);
		JTextField txtFecha = new JTextField();
		txtFecha.setBounds(150, 138, 180, 20);
		txtFecha.setEditable(false);
		panelDatos.add(txtFecha);

		JLabel lblFechaPublicacion = new JLabel("Fecha Publicacion:");
		lblFechaPublicacion.setBounds(30, 170, 126, 16);
		panelDatos.add(lblFechaPublicacion);
		JTextField txtFechaPublicacion = new JTextField();
		txtFechaPublicacion.setBounds(150, 168, 180, 20);
		txtFechaPublicacion.setEditable(false);
		panelDatos.add(txtFechaPublicacion);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 200, 105, 16);
		panelDatos.add(lblPrecio);
		JTextField txtPrecio = new JTextField();
		txtPrecio.setBounds(150, 198, 180, 20);
		txtPrecio.setEditable(false);
		panelDatos.add(txtPrecio);

		JLabel lblMontoNecesario = new JLabel("Monto Necesario:");
		lblMontoNecesario.setBounds(30, 230, 104, 16);
		panelDatos.add(lblMontoNecesario);
		JTextField txtMontoNecesario = new JTextField();
		txtMontoNecesario.setBounds(150, 228, 180, 20);
		txtMontoNecesario.setEditable(false);
		panelDatos.add(txtMontoNecesario);

		JLabel lblMontoRecaudado = new JLabel("Monto Recaudado:");
		lblMontoRecaudado.setBounds(30, 260, 105, 16);
		panelDatos.add(lblMontoRecaudado);
		JTextField txtMontoRecaudado = new JTextField();
		txtMontoRecaudado.setBounds(150, 258, 180, 20);
		txtMontoRecaudado.setEditable(false);
		panelDatos.add(txtMontoRecaudado);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(30, 290, 105, 16);
		panelDatos.add(lblEstado);
		JTextField txtEstado = new JTextField();
		txtEstado.setBounds(150, 288, 180, 20);
		txtEstado.setEditable(false);
		panelDatos.add(txtEstado);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(30, 320, 105, 16);
		panelDatos.add(lblDescripcion);
		JScrollPane scrollDescripcion = new JScrollPane();
		scrollDescripcion.setBounds(30, 346, 300, 60);
		panelDatos.add(scrollDescripcion);
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setEditable(false);
		scrollDescripcion.setViewportView(txtDescripcion);

	       JLabel lblImagenPropuesta = new JLabel("Imagen Propuesta");
	       lblImagenPropuesta.setBounds(373, 30, 126, 16);
	       panelDatos.add(lblImagenPropuesta);
	       JLabel lblImagenPreview = new JLabel();
	       lblImagenPreview.setOpaque(true);
	       lblImagenPreview.setBackground(new Color(154, 153, 150));
	       lblImagenPreview.setBounds(373, 55, 140, 120);
	       lblImagenPreview.setHorizontalAlignment(SwingConstants.CENTER);
	       panelDatos.add(lblImagenPreview);

	       JLabel lblColaboradores = new JLabel("Colaboradores:");
	       lblColaboradores.setBounds(373, 242, 126, 16);
	       panelDatos.add(lblColaboradores);
	       DefaultListModel<String> modeloColaboradores = new DefaultListModel<>();
	       JList<String> listColaboradores = new JList<>(modeloColaboradores);
	       JScrollPane scrollColaboradores = new JScrollPane(listColaboradores);
	       scrollColaboradores.setBounds(373, 268, 140, 138);
	       panelDatos.add(scrollColaboradores);

		   
		   cmbPropuestas.addActionListener(e -> {
			   if (cmbPropuestas.getSelectedIndex() != -1) {
					  panelDatos.setVisible(true);
					  String tituloSeleccionado = (String) cmbPropuestas.getSelectedItem();
					  DTDetallePropuesta propuesta = controller.consultarPropuesta(tituloSeleccionado);

					  // SE MUESTRAN LOS DATOS
					  txtTitulo.setText(propuesta.getTitulo());
					  txtProponente.setText(propuesta.getProponente());
					  txtTipoEspectaculo.setText(propuesta.getTipoEspectaculo());
					  txtLugar.setText(propuesta.getLugar());
					  txtFecha.setText(propuesta.getFecha());
					  txtFechaPublicacion.setText(propuesta.getFechaPublicacion());
					  txtPrecio.setText(String.valueOf(propuesta.getPrecio()));
					  txtMontoNecesario.setText(String.valueOf(propuesta.getMontoNecesario()));
					  txtMontoRecaudado.setText(String.valueOf(propuesta.getMontoRecaudado()));
					  txtEstado.setText(propuesta.getEstado());
					  txtDescripcion.setText(propuesta.getDescripcion());

					  // IMAGEN
					  byte[] imagedata = propuesta.getImagen();
					  if (imagedata != null) {
						  lblImagenPreview.setIcon(new javax.swing.ImageIcon(imagedata));
					  } else {
						  lblImagenPreview.setIcon(null);
					  }

					  // COLABORADORES
					  modeloColaboradores.clear();
					  for (String colaborador : propuesta.getColaboradores()) {
						  modeloColaboradores.addElement(colaborador);
					  }
				  } else {
					  panelDatos.setVisible(false);
				  }
		   });
       }
}

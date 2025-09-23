//clases(Datatypes, enums, controlador)
package GUI;



import logic.IController;
import logic.TipoRetorno;
import logic.Fabric;
import logic.DTColaborador;
import logic.DTEstado;
import logic.DTInfoAporte;
import logic.DTPropCompleto;
import logic.DTPropPersona;
import logic.Estado;

//librerias
import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.text.NumberFormatter;

import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;


public class V_R_ColaboraciónPropuesta extends JInternalFrame {
	// Confirmar cierre al cambiar de opción de menú
	public boolean confirmarCerrar() {
		int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cambiar de opción?", "Confirmar cambio", JOptionPane.YES_NO_OPTION);
		return confirm == JOptionPane.YES_OPTION;
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablelistadoPropuestas;
    private IController controlador;
	
    private JLabel lblNewLabel_1;
    private JTextField txtJhj;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textField_2;
    private JLabel lblNewLabel_5;
    private JTextField textField_3;
    private JLabel lblNewLabel_6;
    private JTextField textField_4;
    private JLabel lblNewLabel_7;
    private JTextField textField_5;
    private JLabel lblNewLabel_8;
    private JTextField textField_6;
    private JLabel lblImagen;
    private JTable tablelistadoEstados;
    private JTable tablelistadoColaboradores;
    private JLabel lblImagen2;
    private JTable tablelistadoAportes;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField  textField_9;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JComboBox<TipoRetorno> combo1;
    private Fabric fabrica = new Fabric();
	private IController usrController = fabrica.getUsrController();

	
	//Constructor por defecto (necesario para WindowBuilder)
	public V_R_ColaboraciónPropuesta() {
		super("Registrar Colaboración a Propuesta", false, false, false, false);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//-----------------------------------------------------PARA LA IMAGEN-----------------------------------------------------------------------------------
	    lblImagen = new JLabel();
	    lblImagen.setBounds(429, 34, 145, 120);
	    contentPane.add(lblImagen);
	    
	    lblImagen2 = new JLabel();
	    lblImagen2.setBounds(444, 254, 140, 103); // (x,y,width height)
	    contentPane.add(lblImagen2);
		
//-----------------------------------------------------TITULO-----------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Registrar Colaboracion a Propuesta");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Rubik", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 9, 281, 19);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		

//-------------------------------------------------PROPUESTA-----------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
		
//---------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------TABLA LISTADO-----------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
		DefaultTableModel model1 = new DefaultTableModel() {
			
			//ESTO PARA QUE NO EDITEN LOS CAMPOS DE LA TABLA
		    public boolean isCellEditable(int row, int column) {
		        return false; // bloquea la edición
		    }
		};
		
		//columnas de la tabla
		model1.addColumn("Titulo");
		model1.addColumn("Nickname");

		//para cargar los datos en la tabla
		List <DTPropPersona>propuestas = usrController.listarPropuestas();
		for(DTPropPersona p : propuestas) {
			model1.addRow(new Object[] {p.getTitulo(),p.getNickname()});

		}
		tablelistadoPropuestas = new JTable(model1);
		tablelistadoPropuestas.setBounds(10, 92, 147, 110);
		contentPane.add(tablelistadoPropuestas);
		tablelistadoPropuestas.getTableHeader().setReorderingAllowed(false);//para que no muevan las columnas de lugar
		tablelistadoPropuestas.getTableHeader().setResizingAllowed(false); //para no redimensionar las columnas
		//tablelistadoPropuestas.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10)); // texto de las celdas

		
		
		
		//para que tenga barra la tabla
		JScrollPane scrollPane = new JScrollPane(tablelistadoPropuestas);
		scrollPane.setEnabled(false);
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 51, 169, 160);
		contentPane.add(scrollPane);
		
		
		

		

//---------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------MENU DE DATOS-----------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
		
		lblNewLabel_1 = new JLabel("Seleccione una Propuesta:");
		lblNewLabel_1.setBounds(10, 34, 169, 19);
		contentPane.add(lblNewLabel_1);
		
		//Titulo
		JLabel lblNewLabel_2 = new JLabel("Titulo");
		lblNewLabel_2.setBounds(189, 36, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtJhj = new JTextField();
		txtJhj.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtJhj.setBounds(189, 59, 102, 20);
		contentPane.add(txtJhj);
		txtJhj.setColumns(10);
		txtJhj.setEditable(false);
		
		//Descripcion
		lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(189, 80, 86, 19);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField.setBounds(189, 101, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		//Lugar
		lblNewLabel_4 = new JLabel("Lugar");
		lblNewLabel_4.setBounds(301, 36, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 59, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel_3_1 = new JLabel("Fecha");
		lblNewLabel_3_1.setBounds(301, 80, 86, 19);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(301, 101, 110, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		lblNewLabel_5 = new JLabel("Precio");
		lblNewLabel_5.setBounds(189, 128, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(189, 143, 102, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		lblNewLabel_6 = new JLabel("Monto necesario");
		lblNewLabel_6.setBounds(301, 129, 102, 12);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(301, 143, 110, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		lblNewLabel_7 = new JLabel("FechaPublicacion");
		lblNewLabel_7.setBounds(189, 174, 102, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(189, 191, 102, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		lblNewLabel_8 = new JLabel("Estado");
		lblNewLabel_8.setBounds(301, 174, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(301, 191, 110, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------CONFIRMAR PROPUESTA-----------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
		
		JButton btnNewButton = new JButton("Confirmar Propuesta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablelistadoPropuestas.getSelectedRow();
				String titulo = ((String) tablelistadoPropuestas.getValueAt(fila, 0)).trim();
				
				if(usrController.PropuestaPermitida(titulo)) {
				usrController.ConfirmarPropuesta(titulo);
				textField_7.setText(titulo);
				}else {
					JOptionPane.showMessageDialog(contentPane, 
		                    "La propuesta '" + titulo + "' no está en un estado válido para confirmar.", 
		                    "Error", 
		                    JOptionPane.ERROR_MESSAGE);
		        }
			}
			
		});
		btnNewButton.setBounds(429, 165, 145, 46);
		contentPane.add(btnNewButton);
		
		//Listener para cargar los datos en los JTextField
		tablelistadoPropuestas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			 public void valueChanged(ListSelectionEvent e) {
			        if (!e.getValueIsAdjusting()) {
			            int fila = tablelistadoPropuestas.getSelectedRow();
			            if (fila != -1) {
			            	System.out.println("Numero de fila" + fila);
			                mostrarDetalleProp(fila);
			            	}
			        	}
			 }
		});	
	
		
//---------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------BOTON HISTORIAL DE ESTADOS----------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
		
		JButton btnNewButton_1 = new JButton("Ver mas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablelistadoPropuestas.getSelectedRow(); // sacamos el numero de la fila seleccionada en la tabla propuestas.
				if(fila == -1) { //si no seleciiono fila
					 JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar una propuesta."); //ERROR
			            return;
				}
				
				String titulo = ((String) tablelistadoPropuestas.getValueAt(fila, 0)).trim(); //sacamos el titulo de la fila seleccionada
				
				// A VER SI ME LLEGA NULO ESTE DTO
				DTPropCompleto dto =usrController.seleccionarPropuesta(titulo); //sacamos el DTPropCompleto de la propuesta seleccionada con el titulo
				System.out.println("DTO recibido: " + dto);
				System.out.println("Titulo: " + dto.getTitulo());
				System.out.println("Descripcion: " + dto.getDescripcion());
				
				
				//Modelo para la tabla de historial de estados
				DefaultTableModel model3 = new DefaultTableModel() {
					
					//ESTO PARA QUE NO EDITEN LOS CAMPOS DE LA TABLA
				    public boolean isCellEditable(int row, int column) {
				        return false; // bloquea la edición
				    }
				};
				
				model3.addColumn("Estado");
				model3.addColumn("Fecha");	
				
				List<Estado> estados = dto.getEstados();
				for(Estado est : estados) {
					model3.addRow(new Object[] {est.getEstado().toString(), est.getFecha().toString()}); //se pasan a String ya que uno es LocalDate y el otro un enum
					}
				
				JTable tablaEstados = new JTable(model3);
				tablaEstados.getTableHeader().setReorderingAllowed(false);//para que no muevan las columnas de lugar
				tablaEstados.getTableHeader().setResizingAllowed(false); //para no redimensionar las columnas
				JScrollPane scroll = new JScrollPane(tablaEstados);
				
				JFrame frameEstados = new JFrame("Historial de Estados");
		        frameEstados.setSize(400, 300);
		        frameEstados.getContentPane().add(scroll);
		        frameEstados.setLocationRelativeTo(null); // centrar
		        frameEstados.setVisible(true);
				
			}
		});
		
		btnNewButton_1.setBounds(350, 172, 61, 14);
		contentPane.add(btnNewButton_1);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------COLABORADOR----------------------------------------------------------------------------------
		
		JLabel lblNewLabel_1_1 = new JLabel("Seleccione un Colaborador");
		lblNewLabel_1_1.setBounds(10, 236, 169, 19);
		contentPane.add(lblNewLabel_1_1);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------LISTA DE COLABORADORES------------------------------------------------------------------------
		
		DefaultTableModel model4 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		model4.addColumn("Nickname");
		model4.addColumn("Nombre");
		//los aportes van despues
		
		List<DTColaborador> colaboradores = usrController.listarColaboradores_RCB();
		for(DTColaborador p : colaboradores) {
			if(p == null) {
				System.out.println("es nulo"); //debugger
			}
			System.out.println(p.getNombre()); //debugger
			model4.addRow(new Object[] {p.getNickname(),p.getNombre()});
		}
		
		tablelistadoColaboradores = new JTable(model4);
		JScrollPane scrollPane2 = new JScrollPane(tablelistadoColaboradores);
		scrollPane2.setBounds(10, 254, 169, 160); 
		contentPane.add(scrollPane2); 
		tablelistadoColaboradores.getTableHeader().setReorderingAllowed(false);//para que no muevan las columnas de lugar
		tablelistadoColaboradores.getTableHeader().setResizingAllowed(false); //para no redimensionar las columnas


//---------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------LISTA DE APORTE-------------------------------------------------------------------------------
	 
		JLabel lblNewLabel_9 = new JLabel("Aportes de Colaborador");
		lblNewLabel_9.setBounds(200, 238, 147, 14);
		contentPane.add(lblNewLabel_9);
		
	 DefaultTableModel model5 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		List<DTColaborador> colaboradores2 = usrController.listarColaboradores_RCB();
		
		
		model5.addColumn("Monto");
		model5.addColumn("Fecha");
		model5.addColumn("Retorno");
		model5.addColumn("Titulo");
		
		
		tablelistadoAportes = new JTable(model5);
		JScrollPane scrollPane3 = new JScrollPane(tablelistadoAportes);
		scrollPane3.setBounds(200, 254, 211, 160); 
		contentPane.add(scrollPane3);
		tablelistadoAportes.getTableHeader().setReorderingAllowed(false); //para que no muevan las columnas de lugar
		tablelistadoAportes.getTableHeader().setResizingAllowed(false); //para no redimensionar las columnas
		tablelistadoAportes.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 9)); // texto de las celdas


		
		JButton btnNewButton_2 = new JButton("Confirmar Colaborador");
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int fila = tablelistadoColaboradores.getSelectedRow();
				String nickname = ((String) tablelistadoColaboradores.getValueAt(fila, 0)).trim();
				usrController.ConfirmarColaborador(nickname);
				textField_8.setText(nickname);
			}
		});
		
		btnNewButton_2.setBounds(429, 368, 145, 46);
		contentPane.add(btnNewButton_2);
		
		//INFO SELECCIONADA
		JLabel lblNewLabel_10 = new JLabel("Propuesta Seleccionada");
		lblNewLabel_10.setBounds(10, 425, 169, 31);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Colaborador Seleccionado");
		lblNewLabel_11.setBounds(10, 482, 169, 29);
		contentPane.add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 452, 169, 29);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 508, 169, 29);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		
	
//---------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------INGRESA LOS DATOS-------------------------------------------------------------------------------		
		//RETORNO
		lblNewLabel_13 = new JLabel("Retorno");
		lblNewLabel_13.setBounds(220, 442, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		combo1  = new JComboBox<TipoRetorno>();
		combo1.setBounds(220, 455, 191, 22);
		contentPane.add(combo1);
		
		combo1.addItem(TipoRetorno.ENTRADA_GRATIS);
		combo1.addItem(TipoRetorno.PORCENTAJE_GANANCIAS);
		
		combo1.setSelectedIndex(-1);
		
		//MONTO
		lblNewLabel_12 = new JLabel("Monto");
		lblNewLabel_12.setBounds(220, 497, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_9 = new JTextField();
		textField_9.setBounds(220, 512, 116, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

//------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------BOTON REGISTRAR---------------------------------------------------------------------------
		
		JButton btnNewButton_3 = new JButton("Registrar");
		btnNewButton_3.setBounds(444, 501, 130, 42);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
//---------------------------------------------------------SACAMOS LOS DATOS INGRESADO y VALIDAMOS------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------
				
				if(textField_7.getText() == null || textField_7.getText().isEmpty()) { //si no confirmo ninguna Propuesta
					JOptionPane.showMessageDialog(null, "Confirme una Propuesta");
					return;
				}
				
				if(textField_8.getText() == null ||textField_8.getText().isEmpty()) { //si no confirmo ningun Colaborador
					JOptionPane.showMessageDialog(null, "Confirme un Colaborador");
					return;
				}
				
				
				TipoRetorno retornoSeleccionado = (TipoRetorno) combo1.getSelectedItem();
				//System.out.println(retornoSeleccionado.toString()); debugger
			    float monto = 0;
			    
			 	try {
			 		monto = Float.parseFloat(textField_9.getText().trim());
			 		
			 		if(monto <= 0) { //si el monto es 0 o menor pedirlo de nuevo
			 		   JOptionPane.showMessageDialog(null, "Monto inválido. Ingrese un número mayor a 0.");
			 	       textField_9.setText("");
			 	       textField_9.requestFocus();
					   return;
					}
			 		
				    //System.out.println("Monto válido: " + monto); //testeo y debuuger
			 		
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "Monto inválido. Ingrese un número válido.");//cartel de error
				    textField_9.setText("");
				    textField_9.requestFocus();
				    return;
				}
			 	
			 	try {
					usrController.Registrar(retornoSeleccionado, monto, textField_8.getText(), textField_7.getText());
					JOptionPane.showMessageDialog(
						null,
						"Colaborador registrado exitosamente",
						"¡Éxito!",
						JOptionPane.INFORMATION_MESSAGE
					);
					dispose();
		        } catch (Exception ex) { //sacamos el error o exception de la funcion Registrar
		            JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage(),
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            	);
		        }
			}
		});
		
		
		
		
//------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------BOTON CANCELAR----------------------------------------------------------------------------
		
		JButton btnNewButton_4 = new JButton("Cancelar");
		btnNewButton_4.setBounds(444, 452, 130, 38);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar y salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});		

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------TABLA DE INFO DE APORTE-------------------------------------------------------------------------------	
		tablelistadoColaboradores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			 public void valueChanged(ListSelectionEvent e) {
			        if (!e.getValueIsAdjusting()) {
			            int fila = tablelistadoColaboradores.getSelectedRow();
			            if(fila != -1) {
			            	String nickname = (String) tablelistadoColaboradores.getValueAt(fila, 0);
			            	
				            List<DTInfoAporte> aportes = usrController.dameAportes(nickname);
				            DefaultTableModel model5 = (DefaultTableModel) tablelistadoAportes.getModel();
				            model5.setRowCount(0);
				            
				            for(DTInfoAporte dto : aportes) {
				            	model5.addRow(new Object[] {dto.getMonto(), dto.getFechaAporte(),dto.getRetorno(), dto.getTitulo()});
				            }
				            
				            DTColaborador colaborador = usrController.BuscarColaborador_RCB(nickname);
				            
				            byte[] imagedata = colaborador.getImagen();
				            if (imagedata != null) {
				            	lblImagen2.setIcon(new javax.swing.ImageIcon(imagedata));
				            }else{
				            		ImagenPorDefecto(lblImagen2);
				            	}
			           }
			      }
			 }
		});	
		
		
		
		
}
//---------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------FUNCIONES AUXILIARES----------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------
	
	 
	 
	 private void mostrarDetalleProp(int fila) { //actualizar los JTextField
			String titulo = ((String) tablelistadoPropuestas.getValueAt(fila, 0)).trim();
			DTPropCompleto dto = usrController.seleccionarPropuesta(titulo);
		      
			if (dto != null) {
				txtJhj.setText(dto.getTitulo());
				textField.setText(dto.getDescripcion());
				textField_1.setText(dto.getLugar());
				LocalDate fecha = dto.getFecha();
				textField_2.setText(fecha.toString());
				String aux;
				textField_3.setText(aux = String.valueOf(dto.getPrecio()));
				String aux2;
				textField_4.setText(aux2 = String.valueOf(dto.getMontoNecesario()));
				LocalDate fecha2 = dto.getFecha();
				textField_5.setText(fecha2.toString());
				textField_6.setText(dto.ultimoEstado(dto.getEstados()).getEstado().toString());

				// Actualizar ComboBox de Retorno
				combo1.removeAllItems();
				if (dto.getTipoRetorno() == logic.TipoRetorno.AMBOS_RETORNOS) {
					combo1.addItem(logic.TipoRetorno.ENTRADA_GRATIS);
					combo1.addItem(logic.TipoRetorno.PORCENTAJE_GANANCIAS);
				} else {
					combo1.addItem(dto.getTipoRetorno());
				}
				combo1.setSelectedIndex(0);

				byte[] imagendata = dto.getImagen();
				if(imagendata != null) {
					lblImagen.setIcon(new javax.swing.ImageIcon(imagendata));
				}else {
					ImagenPorDefecto(lblImagen);
				}
			} else {
				System.out.println("Esta nulo");
			}
		}

	
	private void ImagenPorDefecto(JLabel lblImagen) {
	    lblImagen.setIcon(null);
	    lblImagen.setText("Sin imagen"); 
	    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
	    lblImagen.setVerticalAlignment(SwingConstants.CENTER);
	}
	
	
	public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==combo1) {
            String seleccionado=(String)combo1.getSelectedItem();
            setTitle(seleccionado);
        }
    }
}





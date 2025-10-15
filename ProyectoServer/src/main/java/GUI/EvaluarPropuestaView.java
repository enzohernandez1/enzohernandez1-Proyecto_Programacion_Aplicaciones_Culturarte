package GUI;

import logica.DTDetallePropuesta;
import logica.EstadoENUM;
import logica.Fabric;
import logica.IController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class EvaluarPropuestaView extends JInternalFrame {
    
    private static final long serialVersionUID = 1L;
    private IController controlador;
    private JPanel contentPane;
    private JLabel lblTitulo;
    private JTable table;
    private JLabel lblPropuestas;
    private Fabric fabrica = new Fabric();
    private IController usrController = fabrica.getUsrController();
    
    // Campos para mostrar detalles de la propuesta
    private JTextField txtTitulo;
    private JTextField txtProponente;
    private JTextField txtTipoEspectaculo;
    private JTextField txtLugar;
    private JTextField txtFecha;
    private JTextField txtPrecio;
    private JTextField txtMontoNecesario;
    private JTextField txtMontoRecaudado;
    private JTextField txtEstado;
    private JTextArea txtDescripcion;
    private JLabel lblImagen;
    
    // Botones de acción
    private JButton btnPublicar;
    private JButton btnCancelarPropuesta;
    private JButton btnCerrar;
    
    // Modelo de la tabla
    private DefaultTableModel modeloTabla;
    
    public EvaluarPropuestaView() {
        super("Evaluar Propuesta", false, false, false, false);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // TITULO
        lblTitulo = new JLabel("Evaluar Propuesta");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
        lblTitulo.setBounds(120, 10, 345, 29);
        contentPane.add(lblTitulo);
        
        // TABLA DE PROPUESTAS EN ESTADO "INGRESADA"
        modeloTabla = new DefaultTableModel() {
            // ESTO PARA QUE NO EDITEN LOS CAMPOS DE LA TABLA
            public boolean isCellEditable(int row, int column) {
                return false; // bloquea la edición
            }
        };
        
        modeloTabla.addColumn("Titulo");
        
        table = new JTable(modeloTabla);
        table.getTableHeader().setReorderingAllowed(false); // para que no muevan las columnas de lugar
        table.getTableHeader().setResizingAllowed(false); // para no redimensionar las columnas
        
        JScrollPane scrollPane1 = new JScrollPane(table);
        scrollPane1.setBounds(26, 89, 150, 200);
        contentPane.add(scrollPane1);
        
        lblPropuestas = new JLabel("Propuestas Ingresadas:");
        lblPropuestas.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPropuestas.setBounds(26, 72, 150, 14);
        contentPane.add(lblPropuestas);
        
        // CAMPOS PARA MOSTRAR DETALLES DE LA PROPUESTA
        JLabel lblTituloDetalle = new JLabel("Titulo:");
        lblTituloDetalle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTituloDetalle.setBounds(203, 72, 97, 14);
        contentPane.add(lblTituloDetalle);
        
        txtTitulo = new JTextField();
        txtTitulo.setBounds(203, 88, 180, 20);
        txtTitulo.setEditable(false);
        contentPane.add(txtTitulo);
        
        JLabel lblProponente = new JLabel("Proponente:");
        lblProponente.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblProponente.setBounds(203, 118, 97, 14);
        contentPane.add(lblProponente);
        
        txtProponente = new JTextField();
        txtProponente.setBounds(203, 142, 180, 20);
        txtProponente.setEditable(false);
        contentPane.add(txtProponente);
        
        JLabel lblTipoEspectaculo = new JLabel("Tipo de espectaculo:");
        lblTipoEspectaculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTipoEspectaculo.setBounds(203, 168, 122, 14);
        contentPane.add(lblTipoEspectaculo);
        
        txtTipoEspectaculo = new JTextField();
        txtTipoEspectaculo.setBounds(203, 185, 180, 20);
        txtTipoEspectaculo.setEditable(false);
        contentPane.add(txtTipoEspectaculo);
        
        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLugar.setBounds(203, 215, 83, 14);
        contentPane.add(lblLugar);
        
        txtLugar = new JTextField();
        txtLugar.setBounds(405, 232, 143, 20);
        txtLugar.setEditable(false);
        contentPane.add(txtLugar);
        
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFecha.setBounds(405, 215, 109, 14);
        contentPane.add(lblFecha);
        
        txtFecha = new JTextField();
        txtFecha.setBounds(203, 232, 180, 20);
        txtFecha.setEditable(false);
        contentPane.add(txtFecha);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPrecio.setBounds(405, 257, 109, 14);
        contentPane.add(lblPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(405, 274, 143, 20);
        txtPrecio.setEditable(false);
        contentPane.add(txtPrecio);
        
        JLabel lblMontoNecesario = new JLabel("Monto necesario:");
        lblMontoNecesario.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMontoNecesario.setBounds(203, 257, 110, 14);
        contentPane.add(lblMontoNecesario);
        
        txtMontoNecesario = new JTextField();
        txtMontoNecesario.setBounds(203, 274, 180, 20);
        txtMontoNecesario.setEditable(false);
        contentPane.add(txtMontoNecesario);
        
        JLabel lblMontoRecaudado = new JLabel("Monto recaudado:");
        lblMontoRecaudado.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMontoRecaudado.setBounds(405, 299, 109, 14);
        contentPane.add(lblMontoRecaudado);
        
        txtMontoRecaudado = new JTextField();
        txtMontoRecaudado.setBounds(405, 316, 143, 20);
        txtMontoRecaudado.setEditable(false);
        contentPane.add(txtMontoRecaudado);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEstado.setBounds(203, 299, 110, 14);
        contentPane.add(lblEstado);
        
        txtEstado = new JTextField();
        txtEstado.setBounds(203, 316, 180, 20);
        txtEstado.setEditable(false);
        contentPane.add(txtEstado);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescripcion.setBounds(26, 344, 139, 14);
        contentPane.add(lblDescripcion);
        
        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(250, 367, 380, 120);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        scrollDescripcion.setBounds(26, 368, 380, 120);
        contentPane.add(scrollDescripcion);
        
        // IMAGEN
        JLabel lblImagenTitulo = new JLabel("Imagen Propuesta");
        lblImagenTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblImagenTitulo.setBounds(423, 72, 140, 14);
        contentPane.add(lblImagenTitulo);
        
        lblImagen = new JLabel("");
        lblImagen.setOpaque(true);
        lblImagen.setBackground(new Color(154, 153, 150));
        lblImagen.setBounds(408, 89, 140, 120);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setVerticalAlignment(SwingConstants.CENTER);
        lblImagen.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1));
        contentPane.add(lblImagen);
        
        // BOTONES DE ACCION
        btnPublicar = new JButton("Publicar");
        btnPublicar.setBounds(56, 511, 120, 30);
        btnPublicar.setBackground(new Color(0, 150, 0));
        btnPublicar.setForeground(Color.WHITE);
        btnPublicar.setEnabled(false); // Deshabilitado hasta seleccionar una propuesta
        contentPane.add(btnPublicar);
        
        btnCancelarPropuesta = new JButton("Cancelar Propuesta");
        btnCancelarPropuesta.setBounds(233, 511, 150, 30);
        btnCancelarPropuesta.setBackground(new Color(200, 0, 0));
        btnCancelarPropuesta.setForeground(Color.WHITE);
        btnCancelarPropuesta.setEnabled(false); // Deshabilitado hasta seleccionar una propuesta
        contentPane.add(btnCancelarPropuesta);
        
        // Botón Cerrar
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(448, 515, 100, 22);
        btnCerrar.setBackground(new Color(255, 255, 255));
        btnCerrar.setForeground(new Color(0, 0, 0));
        btnCerrar.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea cerrar esta ventana?",
                "Confirmar cierre",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        contentPane.add(btnCerrar);
        
        // LISTENERS
        
        // Listener para selección en la tabla
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                // Obtener el título de la propuesta de la fila seleccionada
                String tituloSeleccionado = (String) modeloTabla.getValueAt(table.getSelectedRow(), 0);
                
                // Consultar la propuesta
                DTDetallePropuesta propuesta = usrController.consultarPropuesta(tituloSeleccionado);
                
                // Llenar los campos con los datos de la propuesta
                txtTitulo.setText(propuesta.getTitulo());
                txtProponente.setText(propuesta.getProponente());
                txtTipoEspectaculo.setText(propuesta.getTipoEspectaculo());
                txtLugar.setText(propuesta.getLugar());
                txtFecha.setText(propuesta.getFecha());
                txtPrecio.setText(String.valueOf(propuesta.getPrecio()));
                txtMontoNecesario.setText(String.valueOf(propuesta.getMontoNecesario()));
                txtMontoRecaudado.setText(String.valueOf(propuesta.getMontoRecaudado()));
                txtEstado.setText(propuesta.getEstado());
                txtDescripcion.setText(propuesta.getDescripcion());
                
                // Mostrar imagen
                byte[] imagedata = propuesta.getImagen();
                if (imagedata != null) {
                    lblImagen.setIcon(new javax.swing.ImageIcon(imagedata));
                } else {
                    lblImagen.setIcon(null);
                }
                
                // Habilitar botones
                btnPublicar.setEnabled(true);
                btnCancelarPropuesta.setEnabled(true);
            }
        });
        
        // Listener para botón Publicar
        btnPublicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    String tituloSeleccionado = (String) modeloTabla.getValueAt(table.getSelectedRow(), 0);
                    
                    // Obtener fecha actual del sistema
                    LocalDate fechaActual = LocalDate.now();
                    String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    
                    // Cambiar estado a Publicada
                    boolean resultado = usrController.evaluarPropuesta(tituloSeleccionado, EstadoENUM.PUBLICADA, fechaFormateada);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(EvaluarPropuestaView.this, 
                            "La propuesta ha sido publicada exitosamente.", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                        
                        // Actualizar la tabla y limpiar campos
                        cargarPropuestasIngresadas();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(EvaluarPropuestaView.this, 
                            "Error al publicar la propuesta.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        // Listener para botón Cancelar Propuesta
        btnCancelarPropuesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    String tituloSeleccionado = (String) modeloTabla.getValueAt(table.getSelectedRow(), 0);
                    
                    // Confirmar acción
                    int confirmacion = JOptionPane.showConfirmDialog(EvaluarPropuestaView.this,
                        "¿Está seguro que desea cancelar esta propuesta?",
                        "Confirmar cancelación",
                        JOptionPane.YES_NO_OPTION);
                    
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        // Obtener fecha actual del sistema
                        LocalDate fechaActual = LocalDate.now();
                        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        
                        // Cambiar estado a Cancelada
                        boolean resultado = usrController.evaluarPropuesta(tituloSeleccionado, EstadoENUM.CANCELADA, fechaFormateada);
                        
                        if (resultado) {
                            JOptionPane.showMessageDialog(EvaluarPropuestaView.this, 
                                "La propuesta ha sido cancelada.", 
                                "Propuesta cancelada", 
                                JOptionPane.INFORMATION_MESSAGE);
                            
                            // Actualizar la tabla y limpiar campos
                            cargarPropuestasIngresadas();
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(EvaluarPropuestaView.this, 
                                "Error al cancelar la propuesta.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        // Cargar propuestas inicialmente
        cargarPropuestasIngresadas();
    }
    
    private void cargarPropuestasIngresadas() {
        // Limpiar tabla
        modeloTabla.setRowCount(0);
        
        // Obtener propuestas en estado "Ingresada"
        List<String> titulos = usrController.listarPropuestasEstado(EstadoENUM.INGRESADA);
        
        // Agregar títulos a la tabla
        for (String titulo : titulos) {
            modeloTabla.addRow(new Object[]{titulo});
        }
        
        // Limpiar campos y deshabilitar botones
        limpiarCampos();
    }
    
    private void limpiarCampos() {
        txtTitulo.setText("");
        txtProponente.setText("");
        txtTipoEspectaculo.setText("");
        txtLugar.setText("");
        txtFecha.setText("");
        txtPrecio.setText("");
        txtMontoNecesario.setText("");
        txtMontoRecaudado.setText("");
        txtEstado.setText("");
        txtDescripcion.setText("");
        lblImagen.setIcon(null);
        
        // Deshabilitar botones
        btnPublicar.setEnabled(false);
        btnCancelarPropuesta.setEnabled(false);
        
        // Limpiar selección de tabla
        table.clearSelection();
    }
}
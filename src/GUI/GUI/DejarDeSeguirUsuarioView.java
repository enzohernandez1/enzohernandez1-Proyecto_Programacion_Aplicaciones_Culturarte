package GUI;


import logic.IController;
import logic.UsuarioController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DejarDeSeguirUsuarioView extends JInternalFrame {
    private JComboBox<String> cmbSeguidor;
    private JComboBox<String> cmbSeguido;
    private JButton btnDejarSeguir;
    private JTextArea taResultados;
    
    private IController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DejarDeSeguirUsuarioView frame = new DejarDeSeguirUsuarioView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DejarDeSeguirUsuarioView() {
        this.controller = new UsuarioController();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Dejar de Seguir Usuario");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setClosable(true); 
        setMaximizable(true); 
        setIconifiable(true); 
        setResizable(true); 
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        
        panelForm.add(new JLabel("Usuario Seguidor:"));
        cmbSeguidor = new JComboBox<>();
        panelForm.add(cmbSeguidor);

        panelForm.add(new JLabel("Usuario Seguido:"));
        cmbSeguido = new JComboBox<>();
        panelForm.add(cmbSeguido);

        btnDejarSeguir = new JButton("Dejar de Seguir");
        btnDejarSeguir.addActionListener(e -> dejarDeSeguir());
        panelForm.add(btnDejarSeguir);

        panel.add(panelForm, BorderLayout.NORTH);

        taResultados = new JTextArea();
        taResultados.setEditable(false);
        panel.add(new JScrollPane(taResultados), BorderLayout.CENTER);

        add(panel);
        cargarUsuarios();
        actualizarResultados();
        
        JButton btnCancelar = new JButton("Cancelar");
    	btnCancelar.setBackground(new Color(255, 255, 255));
    	btnCancelar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			int confirm = JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
    			if(confirm == 0) { 
    				dispose();
    			}
    		}
    	});
    	btnCancelar.setBounds(123, 500, 106, 27);
    	panel.add(btnCancelar, BorderLayout.SOUTH);
        
        
    }
        
        
    

    private void cargarUsuarios() {
        cmbSeguidor.removeAllItems();
        cmbSeguido.removeAllItems();
        
        try {
            List<String> usuarios = controller.listarUsuarios();
            
            for (String usuario : usuarios) {
                cmbSeguidor.addItem(usuario);
                cmbSeguido.addItem(usuario);
            }
            
            if (usuarios.isEmpty()) {
                taResultados.setText("No hay usuarios registrados en el sistema.");
                btnDejarSeguir.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando usuarios: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            taResultados.setText("Error al conectar con la base de datos.");
            btnDejarSeguir.setEnabled(false);
        }
    }

    private void dejarDeSeguir() {
        String seguidorNick = (String) cmbSeguidor.getSelectedItem();
        String seguidoNick = (String) cmbSeguido.getSelectedItem();

        if (seguidorNick == null || seguidoNick == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar ambos usuarios", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (seguidorNick.equals(seguidoNick)) {
            JOptionPane.showMessageDialog(this, "No puede dejar de seguirse a sí mismo", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            controller.DejarDeSeguirUsuario(seguidorNick, seguidoNick);
            
            JOptionPane.showMessageDialog(this, 
                seguidorNick + " ha dejado de seguir a " + seguidoNick, 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            actualizarResultados();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarResultados() {
        try {
            List<String> seguimientos = controller.listarSeguimientos();
            
            StringBuilder sb = new StringBuilder();
            sb.append("=== RELACIONES DE SEGUIMIENTO ACTIVAS ===\n\n");
            
            if (seguimientos.isEmpty()) {
                sb.append("No hay relaciones de seguimiento activas.\n");
            } else {
                for (String relacion : seguimientos) {
                    sb.append("• ").append(relacion).append("\n");
                }
            }
            
            sb.append("\nTotal: ").append(seguimientos.size()).append(" relaciones activas");
            taResultados.setText(sb.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando seguimientos: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
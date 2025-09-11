package GUI;

import logic.IController;
import logic.UsuarioController;
import logic.DTUsuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SeguirUsuarioView extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4980636302300042614L;
	private JComboBox<String> cmbSeguidor;
    private JComboBox<String> cmbSeguido;
    private JButton btnSeguir;
    private JTextArea taResultados;
    
    private IController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SeguirUsuarioView frame = new SeguirUsuarioView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SeguirUsuarioView() {
        this.controller = new UsuarioController();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Seguir Usuario");
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

        panelForm.add(new JLabel("Usuario a Seguir:"));
        cmbSeguido = new JComboBox<>();
        panelForm.add(cmbSeguido);

        btnSeguir = new JButton("Seguir Usuario");
        btnSeguir.addActionListener(e -> realizarSeguimiento());
        panelForm.add(btnSeguir);

        panel.add(panelForm, BorderLayout.NORTH);

        taResultados = new JTextArea();
        taResultados.setEditable(false);
        panel.add(new JScrollPane(taResultados), BorderLayout.CENTER);

        getContentPane().add(panel);
        cargarUsuarios();
        
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
                btnSeguir.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando usuarios: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarSeguimiento() {
    	
        String seguidorNick = (String) cmbSeguidor.getSelectedItem();
        String seguidoNick = (String) cmbSeguido.getSelectedItem();

        if (seguidorNick == null || seguidoNick == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar ambos usuarios", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (seguidorNick.equals(seguidoNick)) {
            JOptionPane.showMessageDialog(this, "Un usuario no puede seguirse a sí mismo", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            controller.SeguirUsuario(seguidorNick, seguidoNick);
            JOptionPane.showMessageDialog(this, seguidorNick + " ahora sigue a " + seguidoNick, 
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
            sb.append("=== RELACIONES DE SEGUIMIENTO ===\n\n");
            
            if (seguimientos.isEmpty()) {
                sb.append("No hay relaciones de seguimiento.\n");
            } else {
                for (String relacion : seguimientos) {
                    sb.append("• ").append(relacion).append("\n");
                }
            }
            
            sb.append("\nTotal: ").append(seguimientos.size()).append(" relaciones");
            taResultados.setText(sb.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando seguimientos: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   

}
package GUI;
import javax.swing.*;
import javax.swing.tree.*;

import logica.DTCategoria;
import logica.IController;
import logica.Fabric;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
// import eliminado, no es necesario para JInternalFrame

public class AltaCategoriaView extends JInternalFrame {
    private JComboBox<String> comboPadre;
    private JTextField txtNombre;
    private JTree arbolCategorias;
    private DefaultTreeModel modeloArbol;
    private List<DTCategoria> categorias = new ArrayList<>();
    private IController controller = new Fabric().getUsrController();

    // main eliminado, no se usa en JInternalFrame

    public AltaCategoriaView() {
    setTitle("Alta de Categoria");
    setClosable(true);
    setMaximizable(true);
    setIconifiable(true);
    setResizable(true);
    setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    setBounds(0,0,600,600);
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    modeloArbol = new DefaultTreeModel(new DefaultMutableTreeNode("Categorias"));
    panel.setLayout(null);
    arbolCategorias = new JTree(modeloArbol);
    JScrollPane scrollPane = new JScrollPane(arbolCategorias);
    scrollPane.setBounds(10, 41, 564, 436);
    panel.add(scrollPane);

    JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
    panelForm.setBounds(10, 487, 564, 73);

    panelForm.add(new JLabel("Nombre:"));
    txtNombre = new JTextField();
    panelForm.add(txtNombre);

    panelForm.add(new JLabel("Categoria Padre:"));
    comboPadre = new JComboBox<>();
    comboPadre.addItem("Categoria");
    panelForm.add(comboPadre);

    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.addActionListener(e -> agregarCategoria());
    panelForm.add(btnAgregar);

        panel.add(panelForm);

        JButton btnCancelar = new JButton("Cancelar");
        panelForm.add(btnCancelar);
        btnCancelar.setBackground(new Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent arg0) {
                int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
                if(confirm == 0) {
                    dispose();
                }
            }
        });

    cargarDatosIniciales();
    actualizarV();
    getContentPane().add(panel);
    }

    private void cargarDatosIniciales() {
    	categorias.clear();
        List<DTCategoria> obtenidas = controller.getCategorias();
        if (obtenidas != null) {
            categorias.addAll(obtenidas);
        }
    }

    private void agregarCategoria() {
        String nombre = txtNombre.getText().trim();
        String padreNombre = (String) comboPadre.getSelectedItem();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre valido");
            return;
        }
        if (existeCategoria(nombre)) {
            JOptionPane.showMessageDialog(this, "La categoria ya existe");
            return;
        }
        DTCategoria padre = padreNombre.equals("Categoria") ? null : buscarCategoriaPorNombre(padreNombre);
        try {
            controller.AltaCategoria(nombre, padre != null ? padre.getNombre() : null);
            cargarDatosIniciales();
            actualizarV();
            txtNombre.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar categoria: " + ex.getMessage());
        }
    }

    private boolean existeCategoria(String nombre) {
        return categorias.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase(nombre));
    }
    private DTCategoria buscarCategoriaPorNombre(String nombre) {
        return categorias.stream().filter(c -> c.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    private void actualizarV() {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
        modeloArbol.setRoot(raiz);
        comboPadre.removeAllItems();
        comboPadre.addItem("Categoria");
        categorias.stream().filter(c -> c.getNombrePadre() == null).forEach(cat -> {
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat.getNombre());
            raiz.add(construirSubarbol(nodo, cat));
            comboPadre.addItem(cat.getNombre());
        });
        expandirTodoArbol();
    }
    private DefaultMutableTreeNode construirSubarbol(DefaultMutableTreeNode nodoPadre, DTCategoria categoriaPadre) {
        categorias.stream()
            .filter(c -> c.getNombrePadre() != null && c.getNombrePadre().equals(categoriaPadre.getNombre()))
            .forEach(cat -> {
                DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(cat.getNombre());
                nodoPadre.add(construirSubarbol(nodoHijo, cat));
                comboPadre.addItem(cat.getNombre());
            });
        return nodoPadre;
    }

    private void expandirTodoArbol() {
        for (int i = 0; i < arbolCategorias.getRowCount(); i++) {
            arbolCategorias.expandRow(i);
        }
    }
}
package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JMenu;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_menu extends JFrame {
	private JDesktopPane desktopPane;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AltaPerfilView frameUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_menu frame = new main_menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_menu() {
		setResizable(false);
		setTitle("Panel administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 700); // Un poco más ancho para los InternalFrames
		setLocationRelativeTo(null);

		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(246, 245, 244));
		setJMenuBar(menuBar);

		JMenu mnAltas = new JMenu("Altas");
		mnAltas.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAltas);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				try {
					AltaPerfilView altaPerfil = new AltaPerfilView();
					// Título revertido
					desktopPane.add(altaPerfil);
					altaPerfil.setVisible(true);
					int x = (desktopPane.getWidth() - altaPerfil.getWidth()) / 2;
					int y = (desktopPane.getHeight() - altaPerfil.getHeight()) / 2;
					altaPerfil.setLocation(Math.max(x,0), Math.max(y,0));
					altaPerfil.setClosable(false);
					altaPerfil.setMaximizable(false);
					altaPerfil.setIconifiable(false);
					altaPerfil.setResizable(false);
					javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) altaPerfil.getUI();
					ui.setNorthPane(null);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnUsuario.setForeground(new Color(0, 0, 0));
		btnUsuario.setBackground(new Color(255, 255, 255));
		mnAltas.add(btnUsuario);
		
		JButton btnPropuesta = new JButton("Propuesta");
		btnPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				AltaPropuestaView altaPropuesta = new AltaPropuestaView();
				// Título revertido
				desktopPane.add(altaPropuesta);
				altaPropuesta.setVisible(true);
				int x = (desktopPane.getWidth() - altaPropuesta.getWidth()) / 2;
				int y = (desktopPane.getHeight() - altaPropuesta.getHeight()) / 2;
				altaPropuesta.setLocation(Math.max(x,0), Math.max(y,0));
				altaPropuesta.setClosable(false);
				altaPropuesta.setMaximizable(false);
				altaPropuesta.setIconifiable(false);
				altaPropuesta.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) altaPropuesta.getUI();
				ui.setNorthPane(null);
			}
		});
		btnPropuesta.setForeground(new Color(0, 0, 0));
		btnPropuesta.setBackground(new Color(255, 255, 255));
		mnAltas.add(btnPropuesta);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				AltaCategoriaView altaCategoria = new AltaCategoriaView();
				// Título revertido
				desktopPane.add(altaCategoria);
				altaCategoria.setVisible(true);
				int x = (desktopPane.getWidth() - altaCategoria.getWidth()) / 2;
				int y = (desktopPane.getHeight() - altaCategoria.getHeight()) / 2;
				altaCategoria.setLocation(Math.max(x,0), Math.max(y,0));
				altaCategoria.setClosable(false);
				altaCategoria.setMaximizable(false);
				altaCategoria.setIconifiable(false);
				altaCategoria.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) altaCategoria.getUI();
				ui.setNorthPane(null);
			}
		});
		btnCategoria.setForeground(new Color(0, 0, 0));
		btnCategoria.setBackground(new Color(255, 255, 255));
		mnAltas.add(btnCategoria);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setForeground(new Color(0, 0, 0));
		menuBar.add(mnConsultas);
		
		JButton btnColaborador = new JButton("Colaborador");
		btnColaborador.setForeground(new Color(0, 0, 0));
		btnColaborador.setBackground(new Color(255, 255, 255));
		btnColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				ConsultarColaboradorView consultarColaborador = new ConsultarColaboradorView();
				// Título revertido
				desktopPane.add(consultarColaborador);
				consultarColaborador.iniciar();
				int x = (desktopPane.getWidth() - consultarColaborador.getWidth()) / 2;
				int y = (desktopPane.getHeight() - consultarColaborador.getHeight()) / 2;
				consultarColaborador.setLocation(Math.max(x,0), Math.max(y,0));
				consultarColaborador.setClosable(false);
				consultarColaborador.setMaximizable(false);
				consultarColaborador.setIconifiable(false);
				consultarColaborador.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) consultarColaborador.getUI();
				ui.setNorthPane(null);
			}
		});
		mnConsultas.add(btnColaborador);
		
		JButton btnProponente = new JButton("Proponente");
		btnProponente.setForeground(new Color(0, 0, 0));
		btnProponente.setBackground(new Color(255, 255, 255));
		btnProponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				ConsultarProponenteView consultarProponente = new ConsultarProponenteView();
				// Título revertido
				desktopPane.add(consultarProponente);
				consultarProponente.iniciar();
				int x = (desktopPane.getWidth() - consultarProponente.getWidth()) / 2;
				int y = (desktopPane.getHeight() - consultarProponente.getHeight()) / 2;
				consultarProponente.setLocation(Math.max(x,0), Math.max(y,0));
				consultarProponente.setClosable(false);
				consultarProponente.setMaximizable(false);
				consultarProponente.setIconifiable(false);
				consultarProponente.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) consultarProponente.getUI();
				ui.setNorthPane(null);
			}
		});
		mnConsultas.add(btnProponente);
		
		JMenu mnPropuesta = new JMenu("Propuesta");
		mnPropuesta.setBackground(new Color(255, 255, 255));
		mnConsultas.add(mnPropuesta);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setForeground(new Color(0, 0, 0));
		btnNormal.setBackground(new Color(255, 255, 255));
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarPropuestaView consultarPropuesta = new ConsultarPropuestaView();
				desktopPane.add(consultarPropuesta);
				consultarPropuesta.setVisible(true);
				int x = (desktopPane.getWidth() - consultarPropuesta.getWidth()) / 2;
				int y = (desktopPane.getHeight() - consultarPropuesta.getHeight()) / 2;
				consultarPropuesta.setLocation(Math.max(x,0), Math.max(y,0));
				consultarPropuesta.setClosable(false);
				consultarPropuesta.setMaximizable(false);
				consultarPropuesta.setIconifiable(false);
				consultarPropuesta.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) consultarPropuesta.getUI();
				ui.setNorthPane(null);
			}
		});
		mnPropuesta.add(btnNormal);
		
		JButton btnPorEstado = new JButton("Por estado");
		btnPorEstado.setForeground(new Color(0, 0, 0));
		btnPorEstado.setBackground(new Color(255, 255, 255));
		btnPorEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				ConsultarPropPorEstado consultarPorEstado = new ConsultarPropPorEstado();
				desktopPane.add(consultarPorEstado);
				consultarPorEstado.setVisible(true);
				int x = (desktopPane.getWidth() - consultarPorEstado.getWidth()) / 2;
				int y = (desktopPane.getHeight() - consultarPorEstado.getHeight()) / 2;
				consultarPorEstado.setLocation(Math.max(x,0), Math.max(y,0));
				consultarPorEstado.setClosable(false);
				consultarPorEstado.setMaximizable(false);
				consultarPorEstado.setIconifiable(false);
				consultarPorEstado.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) consultarPorEstado.getUI();
				ui.setNorthPane(null);
			}
		});
		mnPropuesta.add(btnPorEstado);
		
		JMenu mnOtros = new JMenu("Otros");
		mnOtros.setForeground(new Color(0, 0, 0));
		mnOtros.setBackground(new Color(255, 255, 255));
		menuBar.add(mnOtros);

		JButton btnRegistrarColaboracion = new JButton("Registrar colaboracion");
		btnRegistrarColaboracion.setBackground(new Color(255, 255, 255));
		btnRegistrarColaboracion.setForeground(new Color(0, 0, 0));
		btnRegistrarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame activo = null;
				for (JInternalFrame frame : desktopPane.getAllFrames()) {
					if (frame.isVisible()) {
						activo = frame;
						break;
					}
				}
				if (activo != null) {
					int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que desea cambiar?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
					if (confirm != 0) {
						return;
					}
					activo.dispose();
				}
				V_R_ColaboraciónPropuesta colaboracionPropuesta = new V_R_ColaboraciónPropuesta();
				desktopPane.add(colaboracionPropuesta);
				colaboracionPropuesta.setVisible(true);
				int x = (desktopPane.getWidth() - colaboracionPropuesta.getWidth()) / 2;
				int y = (desktopPane.getHeight() - colaboracionPropuesta.getHeight()) / 2;
				colaboracionPropuesta.setLocation(Math.max(x,0), Math.max(y,0));
				colaboracionPropuesta.setClosable(false);
				colaboracionPropuesta.setMaximizable(false);
				colaboracionPropuesta.setIconifiable(false);
				colaboracionPropuesta.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) colaboracionPropuesta.getUI();
				ui.setNorthPane(null);
			}
		});
		mnOtros.add(btnRegistrarColaboracion);

		JButton btnModificarPropuesta = new JButton("Modificar propuesta");
		btnModificarPropuesta.setBackground(new Color(255, 255, 255));
		btnModificarPropuesta.setForeground(new Color(0, 0, 0));
		btnModificarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosDePropuestaView modificarPropuesta = new ModificarDatosDePropuestaView();
				desktopPane.add(modificarPropuesta);
				modificarPropuesta.setVisible(true);
				int x = (desktopPane.getWidth() - modificarPropuesta.getWidth()) / 2;
				int y = (desktopPane.getHeight() - modificarPropuesta.getHeight()) / 2;
				modificarPropuesta.setLocation(Math.max(x,0), Math.max(y,0));
				modificarPropuesta.setClosable(false);
				modificarPropuesta.setMaximizable(false);
				modificarPropuesta.setIconifiable(false);
				modificarPropuesta.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) modificarPropuesta.getUI();
				ui.setNorthPane(null);
			}
		});
		mnOtros.add(btnModificarPropuesta);

		// NUEVOS BOTONES PARA COLABORACION PROPUESTA
		JButton btnCancelarColaboracion = new JButton("Cancelar colaboracion propuesta");
		btnCancelarColaboracion.setBackground(new Color(255, 255, 255));
		btnCancelarColaboracion.setForeground(new Color(0, 0, 0));
		btnCancelarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CancelarColaboracionPropuestaView cancelarColaboracion = new CancelarColaboracionPropuestaView();
				desktopPane.add(cancelarColaboracion);
				cancelarColaboracion.setVisible(true);
				int x = (desktopPane.getWidth() - cancelarColaboracion.getWidth()) / 2;
				int y = (desktopPane.getHeight() - cancelarColaboracion.getHeight()) / 2;
				cancelarColaboracion.setLocation(Math.max(x,0), Math.max(y,0));
				cancelarColaboracion.setClosable(false);
				cancelarColaboracion.setMaximizable(false);
				cancelarColaboracion.setIconifiable(false);
				cancelarColaboracion.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) cancelarColaboracion.getUI();
				ui.setNorthPane(null);
			}
		});
		mnOtros.add(btnCancelarColaboracion);

		JButton btnConsultarColaboracion = new JButton("Consultar colaboracion propuesta");
		btnConsultarColaboracion.setBackground(new Color(255, 255, 255));
		btnConsultarColaboracion.setForeground(new Color(0, 0, 0));
		btnConsultarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaColaboracionPropuestaView consultaColaboracion = new ConsultaColaboracionPropuestaView();
				desktopPane.add(consultaColaboracion);
				consultaColaboracion.setVisible(true);
				int x = (desktopPane.getWidth() - consultaColaboracion.getWidth()) / 2;
				int y = (desktopPane.getHeight() - consultaColaboracion.getHeight()) / 2;
				consultaColaboracion.setLocation(Math.max(x,0), Math.max(y,0));
				consultaColaboracion.setClosable(false);
				consultaColaboracion.setMaximizable(false);
				consultaColaboracion.setIconifiable(false);
				consultaColaboracion.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) consultaColaboracion.getUI();
				ui.setNorthPane(null);
			}
		});
		mnConsultas.add(btnConsultarColaboracion);

		JMenu mnSeguidores = new JMenu("Seguidores");
		mnSeguidores.setBackground(new Color(255, 255, 255));
		mnSeguidores.setForeground(new Color(0, 0, 0));
		mnOtros.add(mnSeguidores);

		JButton btnSeguirUsuario = new JButton("Seguir usuario");
		btnSeguirUsuario.setForeground(new Color(0, 0, 0));
		btnSeguirUsuario.setBackground(new Color(255, 255, 255));
		btnSeguirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeguirUsuarioView seguirUsuario = new SeguirUsuarioView();
				desktopPane.add(seguirUsuario);
				seguirUsuario.setVisible(true);
				int x = (desktopPane.getWidth() - seguirUsuario.getWidth()) / 2;
				int y = (desktopPane.getHeight() - seguirUsuario.getHeight()) / 2;
				seguirUsuario.setLocation(Math.max(x,0), Math.max(y,0));
				seguirUsuario.setClosable(false);
				seguirUsuario.setMaximizable(false);
				seguirUsuario.setIconifiable(false);
				seguirUsuario.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) seguirUsuario.getUI();
				ui.setNorthPane(null);
			}
		});
		mnSeguidores.add(btnSeguirUsuario);

		JButton btnDejarDeSeguir = new JButton("Dejar de seguir usuario");
		btnDejarDeSeguir.setForeground(new Color(0, 0, 0));
		btnDejarDeSeguir.setBackground(new Color(255, 255, 255));
		btnDejarDeSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DejarDeSeguirUsuarioView dejarDeSeguir = new DejarDeSeguirUsuarioView();
				desktopPane.add(dejarDeSeguir);
				dejarDeSeguir.setVisible(true);
				int x = (desktopPane.getWidth() - dejarDeSeguir.getWidth()) / 2;
				int y = (desktopPane.getHeight() - dejarDeSeguir.getHeight()) / 2;
				dejarDeSeguir.setLocation(Math.max(x,0), Math.max(y,0));
				dejarDeSeguir.setClosable(false);
				dejarDeSeguir.setMaximizable(false);
				dejarDeSeguir.setIconifiable(false);
				dejarDeSeguir.setResizable(false);
				javax.swing.plaf.basic.BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) dejarDeSeguir.getUI();
				ui.setNorthPane(null);
			}
		});
		mnSeguidores.add(btnDejarDeSeguir);
	// Eliminado: el JDesktopPane debe ser el contenedor principa

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

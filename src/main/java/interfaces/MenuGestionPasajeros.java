package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuGestionPasajeros extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuGestionPasajeros() {
		setTitle("Gestor de Pasajeros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAltaPasaj = new JButton("Alta de Pasajero");
		btnAltaPasaj.setIcon(new ImageIcon(MenuGestionPasajeros.class.getResource("/icons/A\u00F1adir.png")));
		btnAltaPasaj.setHorizontalAlignment(SwingConstants.LEFT);
		btnAltaPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAltaPasaj.setBounds(16, 38, 180, 36);
		contentPane.add(btnAltaPasaj);
		
		JButton btnBuscarPasaj = new JButton("Buscar Pasajero");
		btnBuscarPasaj.setIcon(new ImageIcon(MenuGestionPasajeros.class.getResource("/icons/Buscar.png")));
		btnBuscarPasaj.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarPasaj.setBounds(229, 38, 180, 36);
		contentPane.add(btnBuscarPasaj);
		
		JButton btnModificaPasaj = new JButton("Modificar Pasajero");
		btnModificaPasaj.setIcon(new ImageIcon(MenuGestionPasajeros.class.getResource("/icons/Editar.png")));
		btnModificaPasaj.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificaPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificaPasaj.setBounds(16, 92, 180, 36);
		contentPane.add(btnModificaPasaj);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(MenuGestionPasajeros.class.getResource("/icons/LogOut.png")));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(153, 160, 137, 36);
		contentPane.add(btnSalir);
		
		JButton btnRegistraAcom = new JButton("Registrar Acompa\u00F1ante");
		btnRegistraAcom.setIcon(new ImageIcon(MenuGestionPasajeros.class.getResource("/icons/RegistrarAcompaniante.png")));
		btnRegistraAcom.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistraAcom.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistraAcom.setBounds(229, 92, 180, 36);
		contentPane.add(btnRegistraAcom);
		
		//Acciones de los botones
		
		//Llamar a la interfaz Alta de Pasajero
		btnAltaPasaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AltaPasajero frmBusquedaPasajero = new AltaPasajero();
						frmBusquedaPasajero.setVisible(true);
					}
				});
		
		//Llamar a la interfaz Buscar Pasajero
		btnBuscarPasaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusquedaPasajero frmBusquedaPasajero = new BusquedaPasajero();
				frmBusquedaPasajero.setVisible(true);
			}
		});
		
		//Salir del menú y redireccionar a la pantalla anterior
		btnSalir.addActionListener(e -> 
		{
			Object[] opciones = {"No", "Sí"};
			
			if 
			(	
				opciones
				[JOptionPane.showOptionDialog(
					MenuGestionPasajeros.this, 
					"¿Desea salir del menú Gestión de Pasajeros?", 
					"", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opciones,
					opciones[0]
				)] == opciones[1]
			)
				this.setVisible(false);
				
			
			// TODO: volver al menu anterior
		});
		
	}
}

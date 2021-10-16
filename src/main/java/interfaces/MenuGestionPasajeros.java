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

public class MenuGestionPasajeros extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionPasajeros frame = new MenuGestionPasajeros();
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
	public MenuGestionPasajeros() {
		setTitle("Gestor de Pasajeros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAltaPasaj = new JButton("Alta de Pasajero");
		btnAltaPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAltaPasaj.setBounds(16, 51, 180, 23);
		contentPane.add(btnAltaPasaj);
		
		JButton btnBuscarPasaj = new JButton("Buscar Pasajero");
		btnBuscarPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarPasaj.setBounds(229, 51, 180, 23);
		contentPane.add(btnBuscarPasaj);
		
		JButton btnModificaPasaj = new JButton("Modificar Pasajero");
		btnModificaPasaj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificaPasaj.setBounds(16, 105, 180, 23);
		contentPane.add(btnModificaPasaj);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(153, 173, 137, 23);
		contentPane.add(btnSalir);
		
		JButton btnRegistraAcom = new JButton("Registrar Acompa\u00F1ante");
		btnRegistraAcom.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistraAcom.setBounds(229, 105, 180, 23);
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
					"¿Desea cancelar el alta de pasajero?", 
					"", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opciones,
					opciones[0]
				)] == opciones[1]
			)
				System.exit(0); 
			
			// TODO: volver al menu anterior
		});
		
	}
}

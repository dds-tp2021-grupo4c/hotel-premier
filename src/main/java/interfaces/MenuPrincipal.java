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

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setResizable(false);
		setTitle("Hotel Premier - Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionPasajero = new JButton("Gestionar Pasajero");
		btnGestionPasajero.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGestionPasajero.setBounds(90, 28, 243, 43);
		contentPane.add(btnGestionPasajero);
		
		JButton btnGestionarRespPago = new JButton("Gestionar Responsable Pago");
		btnGestionarRespPago.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionarRespPago.setBounds(388, 30, 240, 43);
		contentPane.add(btnGestionarRespPago);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFacturar.setBounds(90, 82, 243, 43);
		contentPane.add(btnFacturar);
		
		JButton btnOcuparHab = new JButton("Ocupar Habitaci\u00F3n");
		btnOcuparHab.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOcuparHab.setBounds(90, 136, 243, 43);
		contentPane.add(btnOcuparHab);
		
		JButton btnGestionarListados = new JButton("Gestionar Listados");
		btnGestionarListados.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGestionarListados.setBounds(388, 192, 240, 42);
		contentPane.add(btnGestionarListados);
		
		JButton btnReservarHab = new JButton("Reservar Habitaci\u00F3n");
		btnReservarHab.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReservarHab.setBounds(388, 84, 240, 42);
		contentPane.add(btnReservarHab);
		
		JButton btnIngresarNC = new JButton("Ingresar Nota de Cr\u00E9dito");
		btnIngresarNC.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIngresarNC.setBounds(90, 190, 243, 43);
		contentPane.add(btnIngresarNC);
		
		JButton btnIngresarPago = new JButton("Ingresar Pago");
		btnIngresarPago.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIngresarPago.setBounds(388, 138, 240, 42);
		contentPane.add(btnIngresarPago);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalir.setBounds(302, 268, 96, 29);
		contentPane.add(btnSalir);
		

		//Acciones de los botones
		btnGestionPasajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionPasajeros frmGestionPasajeros = new MenuGestionPasajeros();
				frmGestionPasajeros.setVisible(true);
			}
		});
		
		btnSalir.addActionListener(e -> 
		{
			Object[] opciones = {"No", "Sí"};
			
			if 
			(	
				opciones
				[JOptionPane.showOptionDialog(
					MenuPrincipal.this, 
					"¿Desea cancelar el alta de pasajero?", 
					"", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opciones,
					opciones[0]
				)] == opciones[1]
			)
				System.exit(0);  // TODO: volver al menu anterior
		});
	
	}

	
}

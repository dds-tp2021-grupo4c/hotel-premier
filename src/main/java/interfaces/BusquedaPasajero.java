package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Panel;
import java.awt.Font;


import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class BusquedaPasajero extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDocumento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaPasajero frame = new BusquedaPasajero();
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
	public BusquedaPasajero() {
		setTitle("Buscar Pasajeros");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 784, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel BusquedaPasajero = new Panel();
		BusquedaPasajero.setBounds(10, 10, 748, 130);
		contentPane.add(BusquedaPasajero);
		BusquedaPasajero.setLayout(null);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(10, 11, 62, 14);
		BusquedaPasajero.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellido.setBounds(138, 8, 200, 20);
		BusquedaPasajero.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo de Documento:");
		lblTipoDocumento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDocumento.setBounds(10, 59, 131, 14);
		BusquedaPasajero.add(lblTipoDocumento);
		
		JComboBox cbTipoDocumento = new JComboBox();
		cbTipoDocumento.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbTipoDocumento.setBounds(138, 55, 200, 24);
		BusquedaPasajero.add(cbTipoDocumento);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(385, 11, 69, 14);
		BusquedaPasajero.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(538, 8, 200, 20);
		BusquedaPasajero.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNroDocumento = new JLabel("Numero de Documento:");
		lblNroDocumento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNroDocumento.setBounds(385, 59, 157, 14);
		BusquedaPasajero.add(lblNroDocumento);
		
		txtNroDocumento = new JTextField();
		txtNroDocumento.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNroDocumento.setBounds(538, 57, 200, 20);
		BusquedaPasajero.add(txtNroDocumento);
		txtNroDocumento.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(548, 96, 89, 23);
		BusquedaPasajero.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(649, 96, 89, 23);
		BusquedaPasajero.add(btnLimpiar);
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(570, 412, 89, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(669, 412, 89, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 748, 229);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Apellido", "Nombre", "Tipo Documento", "Nro. Documento"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
	;
		//textField.setColumns(10); Me tira Error!
	}
}

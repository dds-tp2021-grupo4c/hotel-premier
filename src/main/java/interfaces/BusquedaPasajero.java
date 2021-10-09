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

@SuppressWarnings("serial")
public class BusquedaPasajero extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDocumento;
	private JTable tablaResultado;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnBuscar.setBounds(548, 96, 89, 23);
		BusquedaPasajero.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(649, 96, 89, 23);
		BusquedaPasajero.add(btnLimpiar);
		
		tablaResultado = new JTable();
		tablaResultado.setBorder(new TitledBorder(null, "Resultado B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tablaResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apellido", "Nombre", "Tipo Documento", "Nro Documento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaResultado.getColumnModel().getColumn(0).setPreferredWidth(86);
		tablaResultado.getColumnModel().getColumn(1).setPreferredWidth(86);
		tablaResultado.getColumnModel().getColumn(2).setPreferredWidth(87);
		tablaResultado.getColumnModel().getColumn(3).setPreferredWidth(86);
		tablaResultado.setBounds(742, 171, -725, 204);
		contentPane.add(tablaResultado);
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(570, 412, 89, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(669, 412, 89, 23);
		contentPane.add(btnCancelar);
	
		
		JPanel panelResultadoBusqueda = new JPanel();
		panelResultadoBusqueda.setBounds(10, 190, 748, 213);
		contentPane.add(panelResultadoBusqueda);
		panelResultadoBusqueda.setLayout(null);
		
		tablaResultado = new JTable();
		tablaResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apellido", "Nombre", "Tipo Documento", "Nro Documento"
			}
		));
		tablaResultado.getColumnModel().getColumn(0).setPreferredWidth(85);
		tablaResultado.getColumnModel().getColumn(1).setPreferredWidth(85);
		tablaResultado.getColumnModel().getColumn(2).setPreferredWidth(87);
		tablaResultado.getColumnModel().getColumn(3).setPreferredWidth(85);
		tablaResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaResultado.setBounds(34, 147, 683, -120);
		panelResultadoBusqueda.add(tablaResultado);
	;
		//textField.setColumns(10); Me tira Error!
	}
}

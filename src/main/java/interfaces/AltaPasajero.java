package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AltaPasajero extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtCalle;
	private JTextField txtDepartamento;
	private JTextField txtLocalidad;
	private JTextField txtTelefono;
	private JTextField txtOcupacion;
	private JTextField txtNombre;
	private JTextField txtNroDocumento;
	private JTextField txtCuit;
	private JTextField txtNumero;
	private JTextField txtPiso;
	private JTextField txtProvincia;
	private JTextField txtCodPostal;
	private JTextField txtEmail;
	private JTextField txtNacionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPasajero frame = new AltaPasajero();
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
	public AltaPasajero() {
		setTitle("Alta de Pasajero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String title = "Alta Pasajero";
		Border border = BorderFactory.createTitledBorder(title);
		//AltaPasajero.setBorder(border);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 782, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblApellido = new JLabel("Apellido (*):");
		lblApellido.setBounds(10, 11, 73, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(152, 8, 189, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento (*):");
		lblTipoDocumento.setBounds(10, 47, 117, 14);
		panel.add(lblTipoDocumento);
		
		JComboBox cbTipoDocumento = new JComboBox();
		cbTipoDocumento.setBounds(152, 39, 189, 24);
		panel.add(cbTipoDocumento);
		
		JLabel lblPosFrenteIVA = new JLabel("Posicion Frente IVA (*):");
		lblPosFrenteIVA.setBounds(10, 85, 131, 14);
		panel.add(lblPosFrenteIVA);
		
		JComboBox cbPosFrenteIVA = new JComboBox();
		cbPosFrenteIVA.setBounds(152, 80, 189, 24);
		panel.add(cbPosFrenteIVA);
		
		JLabel lblFechaNac = new JLabel("Fecha  Nacimiento (*):");
		lblFechaNac.setBounds(10, 120, 131, 14);
		panel.add(lblFechaNac);
		
		JComboBox cbFechaNc = new JComboBox();
		cbFechaNc.setBounds(152, 115, 189, 24);
		panel.add(cbFechaNc);
		
		JLabel lblCalle = new JLabel("Calle (*):");
		lblCalle.setBounds(10, 166, 58, 14);
		panel.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(152, 163, 189, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(10, 208, 98, 14);
		panel.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(152, 205, 189, 20);
		panel.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais (*):");
		lblPais.setBounds(10, 246, 58, 14);
		panel.add(lblPais);
		
		JComboBox cbPais = new JComboBox();
		cbPais.setBounds(152, 241, 189, 24);
		panel.add(cbPais);
		
		JLabel lblLocalidad = new JLabel("Localidad (*):");
		lblLocalidad.setBounds(10, 288, 86, 14);
		panel.add(lblLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(152, 285, 189, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono (*):");
		lblTelefono.setBounds(10, 331, 86, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(152, 328, 189, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblOcupacion = new JLabel("Ocupaci\u00F3n (*):");
		lblOcupacion.setBounds(10, 372, 98, 14);
		panel.add(lblOcupacion);
		
		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(152, 369, 189, 20);
		panel.add(txtOcupacion);
		txtOcupacion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre (*):");
		lblNewLabel.setBounds(433, 14, 73, 14);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(559, 8, 189, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNroDocumento = new JLabel("N\u00FAmero Documento (*):");
		lblNroDocumento.setBounds(425, 47, 124, 14);
		panel.add(lblNroDocumento);
		
		txtNroDocumento = new JTextField();
		txtNroDocumento.setBounds(559, 44, 189, 20);
		panel.add(txtNroDocumento);
		txtNroDocumento.setColumns(10);
		
		JLabel lblCUIT = new JLabel("CUIT (*):");
		lblCUIT.setBounds(433, 85, 58, 14);
		panel.add(lblCUIT);
		
		txtCuit = new JTextField();
		txtCuit.setBounds(559, 82, 189, 20);
		panel.add(txtCuit);
		txtCuit.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero (*):");
		lblNumero.setBounds(433, 166, 73, 14);
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(559, 163, 189, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(433, 208, 46, 14);
		panel.add(lblPiso);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(559, 205, 189, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia (*):");
		lblProvincia.setBounds(433, 246, 73, 14);
		panel.add(lblProvincia);
		
		txtProvincia = new JTextField();
		txtProvincia.setBounds(559, 243, 189, 20);
		panel.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		JLabel lblCodPostal = new JLabel("C\u00F3digo Postal (*):");
		lblCodPostal.setBounds(433, 288, 98, 14);
		panel.add(lblCodPostal);
		
		txtCodPostal = new JTextField();
		txtCodPostal.setBounds(559, 285, 189, 20);
		panel.add(txtCodPostal);
		txtCodPostal.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(433, 331, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(559, 328, 189, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad (*):");
		lblNacionalidad.setBounds(433, 372, 98, 14);
		panel.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(559, 369, 189, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(559, 406, 89, 23);
		panel.add(btnSiguiente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(658, 406, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblInfo = new JLabel("(*) Son campos Requeridos");
		lblInfo.setBounds(10, 415, 159, 14);
		panel.add(lblInfo);
	}
	
	
}

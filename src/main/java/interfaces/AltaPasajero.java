package interfaces;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;

import dtos.AltaPasajeroDTO;
import dtos.LocalidadDTO;
import dtos.PaisDTO;
import dtos.PosicionFrenteIvaDTO;
import dtos.ProfesionDTO;
import dtos.ProvinciaDTO;
import dtos.TipoDocumentoDTO;
import excepciones.DatosNoValidosException;
import excepciones.ExistePasajeroException;
import gestores.GestorGeografico;
import gestores.GestorPersona;
import util.UppercaseDocumentFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AltaPasajero extends JPanel {

	private JFrame ventana;
	private JPanel padre;
	private GestorPersona gestorPersona = GestorPersona.getInstance();
	private GestorGeografico gestorGeografico = GestorGeografico.getInstance();
	private GridBagConstraints gbc;
	private JLabel lblApellido, lblNombre,lblTipoDocumento,lblNroDocumento,lblPosicionIVA,lblCUIT,lblFechaNac,lblCalle,lblNumero,lblDepto,lblPiso,lblPais,lblProvincia,lblLocalidad,
		lblCodigoPostal,lblTelefono,lblEmail,lblOcupacion,lblNacionalidad;
	private JTextField txtApellido,txtCalle,txtDepartamento,txtTelefono,txtNombre,txtNroDocumento,txtNumero,txtPiso,txtCodPostal,txtEmail,txtNacionalidad;
	private JFormattedTextField txtCuit;
	private JComboBox<TipoDocumentoDTO> cbTipoDocumento;
	private JComboBox<PosicionFrenteIvaDTO> cbPosFrenteIVA;
	private JComboBox<PaisDTO> cbPais;
	private JComboBox<ProvinciaDTO> cbProvincia;
	private JComboBox<LocalidadDTO> cbLocalidad;
	private JComboBox<ProfesionDTO> cbOcupacion;
	private JDateChooser fechaNac;
	private JButton btnSiguiente, btnCancelar;
	private MaskFormatter mascaraCuit = null;

	
	public AltaPasajero(JFrame ventana, JPanel padre) {
		this.ventana = ventana;
		this.padre = padre;
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.armarPanel();
	}
	
	public void armarPanel() {
		DocumentFilter filter = new UppercaseDocumentFilter();
		
		lblApellido = new JLabel("Apellido (*)");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblApellido, gbc);
		
		txtApellido = new JTextField();
		((AbstractDocument) txtApellido.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtApellido,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblNombre = new JLabel("Nombre (*)");
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblNombre, gbc);
		
		txtNombre = new JTextField();
		((AbstractDocument) txtNombre.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtNombre,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblTipoDocumento = new JLabel("Tipo Documento (*)");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblTipoDocumento,gbc);
		
		cbTipoDocumento = new JComboBox<TipoDocumentoDTO>();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbTipoDocumento,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxTipoDocumentos();
		cbTipoDocumento.setSelectedIndex(1);
		
		lblNroDocumento = new JLabel("N\u00FAmero Documento (*)");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblNroDocumento,gbc);
		
		txtNroDocumento = new JTextField();
		((AbstractDocument) txtNroDocumento.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtNroDocumento,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblPosicionIVA = new JLabel("Posicion Frente IVA");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblPosicionIVA,gbc);
		
		cbPosFrenteIVA = new JComboBox<PosicionFrenteIvaDTO>();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbPosFrenteIVA,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxPosicionesFrenteIVA();
		
		lblCUIT = new JLabel("CUIT");
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblCUIT,gbc);
		
		try {
			mascaraCuit = new MaskFormatter("##-########-#");
			mascaraCuit.setPlaceholderCharacter('9');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCuit = new JFormattedTextField(mascaraCuit);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtCuit,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblFechaNac = new JLabel("Fecha de Nacimiento (*):");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblFechaNac, gbc);
		
		fechaNac = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaNac.getJCalendar().setMaxSelectableDate(new Date());
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(fechaNac,gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		
		lblCalle = new JLabel("Calle (*)");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblCalle,gbc);
		
		txtCalle = new JTextField();
		((AbstractDocument) txtCalle.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtCalle,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblNumero = new JLabel("N\u00FAmero (*)");
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblNumero,gbc);
		
		txtNumero = new JTextField();
		((AbstractDocument) txtNumero.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtNumero,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblDepto = new JLabel("Departamento");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblDepto,gbc);
		
		txtDepartamento = new JTextField();
		((AbstractDocument) txtDepartamento.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtDepartamento, gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblPiso = new JLabel("Piso");
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblPiso,gbc);
		
		txtPiso = new JTextField();
		((AbstractDocument) txtPiso.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtPiso,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblPais = new JLabel("Pais (*)");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblPais,gbc);
		
		cbPais = new JComboBox<PaisDTO>();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbPais,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxPais();
		cbPais.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					cbProvincia.removeAllItems();
					cbLocalidad.removeAllItems();
					llenarComboBoxProvincias((PaisDTO) cbPais.getSelectedItem());
				}
			}
		});
		
		lblProvincia = new JLabel("Provincia (*)");
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblProvincia,gbc);
		
		cbProvincia = new JComboBox<ProvinciaDTO>();
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbProvincia,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxProvincias((PaisDTO) cbPais.getSelectedItem());
		cbProvincia.setSelectedIndex(19);
		cbProvincia.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					cbLocalidad.removeAllItems();
					llenarComboBoxLocalidades((ProvinciaDTO) cbProvincia.getSelectedItem());
				}
			}
		});
		
		lblLocalidad = new JLabel("Localidad (*)");
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblLocalidad,gbc);
		
		cbLocalidad = new JComboBox<LocalidadDTO>();
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbLocalidad, gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxLocalidades((ProvinciaDTO) cbProvincia.getSelectedItem());
		cbLocalidad.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					txtCodPostal.setText(((LocalidadDTO)cbLocalidad.getSelectedItem()).getCodigoPostal());
				}
			}
		});

		lblCodigoPostal = new JLabel("C\u00F3digo Postal (*)");
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblCodigoPostal,gbc);
		
		txtCodPostal = new JTextField();
		txtCodPostal.setEditable(false);
		txtCodPostal.setText(((LocalidadDTO)cbLocalidad.getSelectedItem()).getCodigoPostal());
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtCodPostal,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblTelefono = new JLabel("Tel\u00E9fono (*)");
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblTelefono,gbc);
		
		txtTelefono = new JTextField();
		((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtTelefono,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblEmail = new JLabel("Email");
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblEmail,gbc);
		
		txtEmail = new JTextField();
		((AbstractDocument) txtEmail.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtEmail,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		lblOcupacion = new JLabel("Ocupaci\u00F3n (*)");
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblOcupacion,gbc);
		
		cbOcupacion = new JComboBox<ProfesionDTO>();
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cbOcupacion, gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		llenarComboBoxOcupaciones();
		
		lblNacionalidad = new JLabel("Nacionalidad (*)");
		gbc.gridx = 3;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblNacionalidad,gbc);
		
		txtNacionalidad = new JTextField();
		((AbstractDocument) txtNacionalidad.getDocument()).setDocumentFilter(filter);
		gbc.gridx = 4;
		gbc.gridy = 9;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtNacionalidad,gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		btnSiguiente = new JButton("Siguiente");
		gbc.gridx = 4;
		gbc.gridy = 10;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnSiguiente,gbc);
		
		btnCancelar = new JButton("Cancelar");
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 5;
		gbc.gridy = 10;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnCancelar,gbc);
		gbc.anchor = GridBagConstraints.CENTER;

		btnSiguiente.addActionListener(
				e -> {
					if( ((PosicionFrenteIvaDTO)cbPosFrenteIVA.getSelectedItem()).getNombre().equals("<SELECCIONAR>") ) cbPosFrenteIVA.setSelectedIndex(1);
					if(validarDatosObligatorios() && validarLongitudYFormatoDatos()) {
						String cuit = txtCuit.getText().equals("99-99999999-9") ? "" : txtCuit.getText();
						TipoDocumentoDTO tipoDoc = (TipoDocumentoDTO) cbTipoDocumento.getSelectedItem();
						PosicionFrenteIvaDTO posIva = (PosicionFrenteIvaDTO) cbPosFrenteIVA.getSelectedItem();
						LocalidadDTO localidad = (LocalidadDTO) cbLocalidad.getSelectedItem();
						ProfesionDTO profesion = (ProfesionDTO) cbOcupacion.getSelectedItem();
						LocalDate fecha_nacimiento = fechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						AltaPasajeroDTO altaPasajeroDTO = new AltaPasajeroDTO(txtApellido.getText(), txtNombre.getText(), tipoDoc.getId(), txtNroDocumento.getText(),cuit,
								posIva.getId(), fecha_nacimiento, txtCalle.getText(), txtNumero.getText(), txtDepartamento.getText(),txtPiso.getText(), localidad.getId(),
								txtTelefono.getText(), txtEmail.getText(), profesion.getId(),txtNacionalidad.getText());
						try {
							gestorPersona.altaPasajero(altaPasajeroDTO, true);
							mostrarMensajePasajeroAgregado();
						} catch (DatosNoValidosException e1) {
							mostrarMensajeDatosFaltantes();
							mostrarMensajeLongitudYFormatoDatos();
						} catch (ExistePasajeroException e1) {
							String mensaje = "¡CUIDADO! El tipo y numero de numero de documento ya existen en el sistema";
							int confirmado = JOptionPane.showOptionDialog(
									this, 
									mensaje, 
									"ADVERTENCIA", 
									JOptionPane.YES_NO_OPTION, 
									JOptionPane.WARNING_MESSAGE, 
									null, 
									new Object[] {"Aceptar Igualmente","Corregir"}, 
									"Aceptar Igualmente");
							if(confirmado == 0) {
								try {
									gestorPersona.altaPasajero(altaPasajeroDTO, false);
									mostrarMensajePasajeroAgregado();
								} catch (DatosNoValidosException | ExistePasajeroException e2) {
									//En este caso no va a pasar nunca
								}
							}else {
								cbTipoDocumento.requestFocus();
							}
						}
					}
					if(!validarDatosObligatorios())
						mostrarMensajeDatosFaltantes();
					if(!validarLongitudYFormatoDatos())
						mostrarMensajeLongitudYFormatoDatos();
				}				
		);
		
		btnCancelar.addActionListener(
				e -> {
					String mensaje = "¿Deseas cancelar el alta de pasajero?";
					int confirmado = JOptionPane.showOptionDialog(
							this, 
							mensaje, 
							"CONFIRMACION", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE, 
							null, 
							new Object[] {"SI","NO"}, 
							"SI");
					if(confirmado == 0) {
						ventana.setTitle("Pasajeros");
						((BusquedaPasajero) padre).interfazPorDefecto();
						ventana.setContentPane(padre);
						ventana.setVisible(true);
					}
				}
		);
	}

	private void llenarComboBoxLocalidades(ProvinciaDTO selectedItem) {
		List<LocalidadDTO> listaLocalidades = selectedItem.getLocalidades();
		LocalidadDTO seleccionar = new LocalidadDTO(0, "<SELECCIONAR>", "");
		cbLocalidad.addItem(seleccionar);
		listaLocalidades.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(LocalidadDTO unaLocalidad : listaLocalidades) {
			cbLocalidad.addItem(unaLocalidad);
		}
	}

	private void llenarComboBoxProvincias(PaisDTO selectedItem) {
		List<ProvinciaDTO> listaProvincias = selectedItem.getProvincias();
		listaProvincias.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(ProvinciaDTO unaProvincia : listaProvincias) {
			cbProvincia.addItem(unaProvincia);
		}
	}

	private void llenarComboBoxPais() {
		List<PaisDTO> listaPaises = gestorGeografico.getUbicaciones();
		cbPais.removeAllItems();
		listaPaises.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(PaisDTO unPais : listaPaises) {
			cbPais.addItem(unPais);
		}
	}

	private void llenarComboBoxTipoDocumentos() {
		List<TipoDocumentoDTO> listaDoc = gestorPersona.getTiposDocumentos();
		cbTipoDocumento.removeAllItems();
		listaDoc.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(TipoDocumentoDTO unTipoDoc : listaDoc) {
			cbTipoDocumento.addItem(unTipoDoc);
		}
	}

	private void llenarComboBoxPosicionesFrenteIVA() {
		List<PosicionFrenteIvaDTO> listaPosIVA = gestorPersona.getPosicionesIVA();
		cbPosFrenteIVA.removeAllItems();
		PosicionFrenteIvaDTO seleccionar = new PosicionFrenteIvaDTO(0, "<SELECCIONAR>");
		cbPosFrenteIVA.addItem(seleccionar);
		listaPosIVA.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(PosicionFrenteIvaDTO unaPosIva : listaPosIVA) {
			cbPosFrenteIVA.addItem(unaPosIva);
		}
	}

	private void llenarComboBoxOcupaciones() {
		List<ProfesionDTO> listaProfesiones = gestorPersona.getProfesiones();
		cbOcupacion.removeAllItems();
		ProfesionDTO seleccionar = new ProfesionDTO(0, "<SELECCIONAR>");
		cbOcupacion.addItem(seleccionar);
		listaProfesiones.sort((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()));
		for(ProfesionDTO unaProfesion : listaProfesiones) {
			cbOcupacion.addItem(unaProfesion);
		}
	}

	private boolean validarDatosObligatorios() {
		if(txtApellido.getText().isBlank() || txtNombre.getText().isBlank() || txtNroDocumento.getText().isBlank() || fechaNac.getDate() == null
				|| txtCalle.getText().isBlank() || txtNumero.getText().isBlank()  || cbLocalidad.getSelectedIndex() == 0 || txtTelefono.getText().isBlank() 
				|| cbOcupacion.getSelectedIndex() == 0 || txtNacionalidad.getText().isBlank()) return false;
		PosicionFrenteIvaDTO posIvaDTO = gestorPersona.getPosicionFrenteIVAById(((PosicionFrenteIvaDTO)cbPosFrenteIVA.getSelectedItem()).getId());
		if(posIvaDTO.getNombre().equals("Responsable Inscripto") && txtCuit.getText().equals("99-99999999-9")) return false;
		return true;
	}

	private void mostrarMensajeDatosFaltantes() {
		String mensaje = "Los siguientes campos son obligatorios: \n";
		if(txtApellido.getText().isBlank()) mensaje += "	Apellido.\n";
		if(txtNombre.getText().isBlank()) mensaje += "	Nombre.\n";
		if(txtNroDocumento.getText().isBlank()) mensaje += "	Numero de documento.\n";
		if(fechaNac.getDate() == null) mensaje += "	Fecha de nacimiento.\n";
		if(txtCalle.getText().isBlank()) mensaje += "Calle.\n";
		if(txtNumero.getText().isBlank()) mensaje += "Numero.\n";
		if(cbLocalidad.getSelectedIndex() == 0) mensaje += "Localidad.\n";
		if(txtTelefono.getText().isBlank()) mensaje += "Telefono.\n";
		if(cbOcupacion.getSelectedIndex() == 0) mensaje += "Ocupacion.\n";
		if(txtNacionalidad.getText().isBlank()) mensaje += "Nacionalidad.\n";
		PosicionFrenteIvaDTO posIvaDTO = (PosicionFrenteIvaDTO) cbPosFrenteIVA.getSelectedItem();
		if(posIvaDTO.getNombre().equals("Responsable Inscripto") && txtCuit.getText().equals("99-99999999-9")) mensaje += "Cuit, si la posicion frente al iva seleccionado es 'Responsable Inscripto'.";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	private boolean validarLongitudYFormatoDatos() {
		if(txtApellido.getText().length() > 50 || txtNombre.getText().length() > 50 || txtNroDocumento.getText().length() > 10
				|| txtCalle.getText().length() > 50 || txtNumero.getText().length() > 10
				|| txtDepartamento.getText().length() > 10 || txtPiso.getText().length() > 10 || txtTelefono.getText().length() > 30
				|| txtEmail.getText().length() > 70 || txtNacionalidad.getText().length() > 30) return false;
		if(!txtEmail.getText().equals("")) {
			Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
		    Matcher mat = pat.matcher(txtEmail.getText());
		    if(!mat.find()) return false;
		}
		return true;
	}

	private void mostrarMensajeLongitudYFormatoDatos() {
		String mensaje = "Los siguientes campos deben tener como maximo la longitud definida:\n";
		if(txtApellido.getText().length() > 50) mensaje += "	Apellido (50 caracteres maximo)\n";
		if(txtNombre.getText().length() > 50) mensaje += "	Nombre (50 caracteres maximo)\n";
		if(txtNroDocumento.getText().length() > 10) mensaje += "	Numero de Documento (10 caracteres maximo)\n";
		if(txtCalle.getText().length() > 50) mensaje += "	Calle (50 caracteres maximo)\n";
		if(txtNumero.getText().length() > 10) mensaje += "	Numero (10 caracteres maximo)\n";
		if(txtDepartamento.getText().length() > 10) mensaje += "	Departamento (10 caracteres maximo)\n";
		if(txtPiso.getText().length() > 10) mensaje += "	Piso (10 caracteres como maximo)\n";
		if(txtTelefono.getText().length() > 30) mensaje += "	Telefono (30 caracteres como maximo)\n";
		if(txtEmail.getText().length() > 70) mensaje += "	Email (70 caracteres como maximo)\n";
		if(txtNacionalidad.getText().length() > 30) mensaje += "	Nacionalidad (30 caracteres como maximo)\n";
		if(!txtEmail.getText().equals("")) {
			Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
		    Matcher mat = pat.matcher(txtEmail.getText());
		    if(!mat.find()) mensaje += "El formato del email es el siguiente: xxxx@xxxxx.xxx";
		}
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	private void mostrarMensajePasajeroAgregado() {
		String mensaje = "El pasajero " + txtNombre.getText() + " " + txtApellido.getText() + " ha sido satisfactoriamente cargado al sistema. ¿Desea cargar otro?";
		int confirmado = JOptionPane.showOptionDialog(
				this, 
				mensaje, 
				"CONFIRMACION", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				new Object[] {"SI","NO"}, 
				"SI");
		if(confirmado == 0) {
			ventana.setContentPane(new AltaPasajero(ventana, padre));
			ventana.setVisible(true);
		} else {
			ventana.setTitle("Pasajeros");
			((BusquedaPasajero) padre).interfazPorDefecto();
			ventana.setContentPane(padre);
			ventana.setVisible(true);
		}
	}
}

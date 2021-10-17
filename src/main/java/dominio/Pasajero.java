package dominio;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dtos.AltaPasajeroDTO;

@Entity
@Table(name = "pasajero")
public class Pasajero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;

	@Column
	private String apellido;

	@Column
	private String nombre;

	@Column(name = "nro_documento")
	private String numDocumento;

	@Column
	private String telefono;

	@Column
	private String cuit;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNac;

	@Column
	private String email;

	@Column
	private String nacionalidad;

	@Column
	private String calle;

	@Column(name = "nro_calle")
	private String numero;

	@Column
	private String departamento;

	@Column
	private int piso;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
	private TipoDocumento tipoDocumento;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_posicion_frente_iva", referencedColumnName = "id")
	private PosicionFrenteIVA posicionFrenteIva;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_profesion", referencedColumnName = "id")
	private Profesion profesion;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_localidad", referencedColumnName = "id")
	private Localidad localidad;

	public Pasajero() {
	}

	public Pasajero(int id, String apellido, String nombre, String numDocumento, String telefono, String cuit,
			LocalDate fechaNac, String email, String nacionalidad, String calle, String numero, String departamento,
			int piso, TipoDocumento tipoDocumento, PosicionFrenteIVA posicionFrenteIva, Profesion profesion,
			Localidad localidad) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.numDocumento = numDocumento;
		this.telefono = telefono;
		this.cuit = cuit;
		this.fechaNac = fechaNac;
		this.email = email;
		this.nacionalidad = nacionalidad;
		this.calle = calle;
		this.numero = numero;
		this.departamento = departamento;
		this.piso = piso;
		this.tipoDocumento = tipoDocumento;
		this.posicionFrenteIva = posicionFrenteIva;
		this.profesion = profesion;
		this.localidad = localidad;
	}
	
	public Pasajero(AltaPasajeroDTO p) {
		super();
		//this.id = id; Como lo implementamos
		this.apellido = p.getApellido();
		this.nombre = p.getNombre();
		this.numDocumento = p.getNumero();
		this.telefono = p.getTelefono();
		this.cuit = p.getCuit();
		this.fechaNac = p.getFechaNacimiento();
		this.email = p.getEmail();
		this.nacionalidad = p.getNacionalidad();
		this.calle = p.getCalle();
		this.numero = p.getNumero();
		this.departamento = p.getDepartamento();
		this.piso = p.getPiso();
		/*this.tipoDocumento = p.getTipoDocumentoID();
		this.posicionFrenteIva = p.getPosicionFrenteIVAID();
		this.profesion = p.getProfesionID();
		this.localidad = p.getLocalidadID();*/
		
		//REDEFINIR EN EL DTO DE PASAJERO:
		// posicionFrenteIVA es del tipo PosicionFrenteIVA
		// profesion del tipor Profesion
		//localidad del tipo Localidad
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public PosicionFrenteIVA getPosicionFrenteIva() {
		return posicionFrenteIva;
	}

	public void setPosicionFrenteIva(PosicionFrenteIVA posicionFrenteIva) {
		this.posicionFrenteIva = posicionFrenteIva;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}

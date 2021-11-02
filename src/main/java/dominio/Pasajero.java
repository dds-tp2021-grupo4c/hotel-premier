package dominio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Date fechaNac;

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
	private String piso;

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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
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

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
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

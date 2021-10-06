package dominio;

import java.time.LocalDate;

public class Pasajero {
	private int	id;
	private String apellido;
	private String nombre;
	private String numDocumento;
	private String telefono;
	private String cuit;
	private LocalDate fechaNac;
	private String email;
	private String nacionalidad;
	private String calle;
	private String numero;
	private String departamento;
	private int piso;
	private TipoDocumento tipoDocumento;
	private PosicionFrenteIVA posicionFrenteIva;
	private Profesion profesion;
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

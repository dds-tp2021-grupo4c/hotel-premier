package dtos;

import java.time.LocalDate;

public class AltaPasajeroDTO {
	private String apellido;
	private String nombre;
	private int tipoDocumentoID;
	private String documento;
	private String cuit;
	private int posicionFrenteIVAID;
	private LocalDate fechaNacimiento;
	private String calle;
	private String numero;
	private String departamento;
	private int piso;
	private int localidadID;
	private String telefono;
	private String email;
	private int profesionID;
	private String nacionalidad;

	public AltaPasajeroDTO(String apellido, String nombre, int tipoDocumentoID, String documento, String cuit,
			int posicionFrenteIVAID, LocalDate fechaNacimiento, String calle, String numero, String departamento,
			int piso, int localidadID, String telefono, String email, int profesionID,
			String nacionalidad) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumentoID = tipoDocumentoID;
		this.documento = documento;
		this.cuit = cuit;
		this.posicionFrenteIVAID = posicionFrenteIVAID;
		this.fechaNacimiento = fechaNacimiento;
		this.calle = calle;
		this.numero = numero;
		this.departamento = departamento;
		this.piso = piso;
		this.localidadID = localidadID;
		this.telefono = telefono;
		this.email = email;
		this.profesionID = profesionID;
		this.nacionalidad = nacionalidad;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTipoDocumentoID() {
		return tipoDocumentoID;
	}

	public String getDocumento() {
		return documento;
	}

	public String getCuit() {
		return cuit;
	}

	public int getPosicionFrenteIVAID() {
		return posicionFrenteIVAID;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public String getNumero() {
		return numero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public int getPiso() {
		return piso;
	}

	public int getLocalidadID() {
		return localidadID;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public int getProfesionID() {
		return profesionID;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
}

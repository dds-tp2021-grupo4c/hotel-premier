package dtos;

public class BusquedaPasajeroDTO {
	private String apellido;
	private String nombre;
	private int tipoDocumentoID;
	private String documento;

	public BusquedaPasajeroDTO(String apellido, String nombre, int tipoDocumentoID, String documento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumentoID = tipoDocumentoID;
		this.documento = documento;
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
}

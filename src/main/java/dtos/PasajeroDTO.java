package dtos;

public class PasajeroDTO {
	private int id;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String documento;

	public PasajeroDTO(int id, String nombre, String apellido, String tipoDocumento, String documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}
}

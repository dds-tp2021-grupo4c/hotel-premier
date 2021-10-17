package dtos;

public class TipoDocumentoDTO {
	//Atributes
	private Integer idTipoDocumento;
	private String tipo;
	
	//Constructor
	public TipoDocumentoDTO(Integer idTipoDocumento, String tipo) {
		this.idTipoDocumento = idTipoDocumento;
		this.tipo = tipo;
	}
	
	//Getters and Setters
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	
	public void setidTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String nombre) {
		this.tipo = nombre;
	}
	
	public String toString() {
		return tipo;
	}

}

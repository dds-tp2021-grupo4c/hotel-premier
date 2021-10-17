package dtos;

public class PosicionIVADTO {
	//Atributes
	private Integer IdPosicionFrenteIVA;
	private String Posicion;
	
	//Constructor
	public PosicionIVADTO(Integer IdPosiconFrenteIVA, String Posicion) {
		super();
		this.IdPosicionFrenteIVA = IdPosicionFrenteIVA;
		this.Posicion = Posicion;
	}
	
	//Getters and Setters
	public Integer getIdPosicionIva() {
		return IdPosicionFrenteIVA;
	}
	
	public void setIdPosicionIva(Integer IdPosicionFrenteIVA) {
		this.IdPosicionFrenteIVA = IdPosicionFrenteIVA;
	}
	
	public String getPosicion() {
		return Posicion;
	}
	
	public void setPosicion(String Posicion) {
		this.Posicion = Posicion;
	}
	
	public String toString() {
		return Posicion;
	}
}

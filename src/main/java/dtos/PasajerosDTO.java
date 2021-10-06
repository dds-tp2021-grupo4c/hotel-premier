package dtos;

import java.util.List;

public class PasajerosDTO {
	private List<PasajeroDTO> pasajeros;

	public PasajerosDTO(List<PasajeroDTO> pasajeros) {
		super();
		this.pasajeros = pasajeros;
	}

	public List<PasajeroDTO> getPasajeros(){
		return pasajeros;
	}
}

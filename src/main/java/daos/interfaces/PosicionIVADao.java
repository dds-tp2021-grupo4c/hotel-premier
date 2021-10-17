package daos.interfaces;

import java.util.List;

import dominio.PosicionFrenteIVA;

public interface PosicionIVADao {

	public List<PosicionFrenteIVA> obtener();
	
	public PosicionFrenteIVA obtenerPorId(Integer IdPosicionIVA);
}

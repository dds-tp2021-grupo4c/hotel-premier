package daos.interfaces;

import dominio.PosicionFrenteIVA;
import dominio.Profesion;
import dominio.TipoDocumento;

public interface PersonaDao {
	public boolean existePasajeroConMismoTipoYnumeroDocumento(int tipoDocumentoID, String documento);
	public TipoDocumento getTipoDocumentoById(int tipoDocumentoID);
	public PosicionFrenteIVA getPosicionFrenteIVAById(int posicionFrenteIVAID);
	public Profesion getProfesiondById(int profesionID);
}

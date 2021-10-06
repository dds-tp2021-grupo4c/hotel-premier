package daos.interfaces.implementaciones;

import daos.interfaces.PersonaDao;
import dominio.PosicionFrenteIVA;
import dominio.Profesion;
import dominio.TipoDocumento;

public class PersonaPostgreSQLDao implements PersonaDao {

	@Override
	public boolean existePasajeroConMismoTipoYnumeroDocumento(int tipoDocumentoID, String documento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TipoDocumento getTipoDocumentoById(int tipoDocumentoID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PosicionFrenteIVA getPosicionFrenteIVAById(int posicionFrenteIVAID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesion getProfesiondById(int profesionID) {
		// TODO Auto-generated method stub
		return null;
	}

}

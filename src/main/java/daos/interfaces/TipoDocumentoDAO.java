package daos.interfaces;

import java.util.List;

import dominio.TipoDocumento;

public interface TipoDocumentoDAO {
	
	//Methods
	public TipoDocumento obtenerPorId(int id);
	
	public List<TipoDocumento> obtener();

}

package daos.interfaces;

import java.util.List;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;

public interface GeograficoDao {
	public Localidad getLocalidadById(int localidadID);
	public List<Pais> getPaises();
	public List<Provincia> getProvinciasByIdPais(int paisID);
	public List<Localidad> getLocalidadesByIdProvincia(int provinciaID);
}

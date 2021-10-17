package gestores;

import java.util.ArrayList;
import java.util.List;

import daos.factories.GeograficoFactoryDao;
import daos.factories.PersonaFactoryDao;
import daos.interfaces.GeograficoDao;
import daos.interfaces.PersonaDao;
import daos.interfaces.PosicionIVADao;
import daos.interfaces.TipoDocumentoDAO;
import daos.interfaces.implementaciones.PersonaPostgreSQLDao;
import daos.interfaces.implementaciones.PosicionIVASQLDao;
import daos.interfaces.implementaciones.TipoDocumentoSQLDAO;
import dominio.Localidad;
import dominio.Pasajero;
import dominio.PosicionFrenteIVA;
import dominio.TipoDocumento;
import dtos.AltaPasajeroDTO;
import dtos.PosicionIVADTO;
import dtos.TipoDocumentoDTO;
import excepciones.DocumentoExistenteException;

public class GestorPersona {
	private static GestorPersona instancia;
	private PersonaFactoryDao personaFactory;
	private PersonaDao personaDao;
	private GeograficoFactoryDao geograficoFactory;
	private GeograficoDao geograficoDao;
	
	public synchronized static GestorPersona getInstance() {
		if(instancia == null)
			instancia= new GestorPersona();
		return instancia;
	}
	
	public static List<TipoDocumentoDTO> obtenerTodosPorTipoDocumento() {
		TipoDocumentoSQLDAO tDocumentoDAO = new TipoDocumentoSQLDAO();
		
		//Obtener todos los tipos de Documentos
		List<TipoDocumento> tiposDoc = tDocumentoDAO.obtener();
		
		List<TipoDocumentoDTO> res = new ArrayList<TipoDocumentoDTO>();
		
		for(TipoDocumento t : tiposDoc) {
			res.add(new TipoDocumentoDTO(t.getId(), t.getNombre()));
		}
		
		return res;
		
	}
	
	//Posiciones Frente al IVA
	public static List<PosicionIVADTO> obtenerTodasLasPosicionesIVA(){
		PosicionIVADao tipoDocumento = new PosicionIVASQLDao();
		
		List<PosicionFrenteIVA> posicionesIVA = tipoDocumento.obtener();
		
		List<PosicionIVADTO> res = new ArrayList<PosicionIVADTO>();
		
		for(PosicionFrenteIVA p : posicionesIVA) {
			res.add(new PosicionIVADTO(p.getId(), p.getNombre()));
		}
		
		return res;
	}
	
	//Alta de Pasajero
	public static void AltaPasajero(AltaPasajeroDTO p, boolean DocumentoValido) throws DocumentoExistenteException {
		boolean DocumentoExiste = false;
		
		if(DocumentoValido)
			DocumentoExiste = GestorPersona.DocumentoExistente(p);
		
		if(DocumentoExiste) {
			throw new DocumentoExistenteException();
		}
		
		Pasajero pasajero = new Pasajero(p); //p es del tipo DTO, debemos pasar un objeto DTO
		TipoDocumento tipoDoc = new TipoDocumentoSQLDAO().obtenerPorId(p.getTipoDocumentoID()); //No se si está bien
		// Localidad loc = new GeograficoDao().getLocalidadById(p.getLocalidadID()); Me da error
		
		//Falta implementar bien esto !!!!
		
		
	}
	
	

	private static boolean DocumentoExistente(AltaPasajeroDTO p) {
		//PersonaDao per = new PersonaPostgreSQLDao();
		//IMPLEMENTAR
		return false;
	}

	private GestorPersona() {
	}
}

package gestores;

import daos.factories.GeograficoFactoryDao;
import daos.factories.PersonaFactoryDao;
import daos.interfaces.GeograficoDao;
import daos.interfaces.PersonaDao;

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

	private GestorPersona() {
	}
}

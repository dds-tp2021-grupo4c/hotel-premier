package daos.factories;

import daos.interfaces.PersonaDao;
import daos.interfaces.implementaciones.PersonaPostgreSQLDao;

public class PostgreSQLPersonaFactoryDao extends PersonaFactoryDao {

	@Override
	public PersonaDao getPersonaDAO() {
		return new PersonaPostgreSQLDao();
	}
}

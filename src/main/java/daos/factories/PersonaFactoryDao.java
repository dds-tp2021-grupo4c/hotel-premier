package daos.factories;

import daos.interfaces.PersonaDao;

public abstract class PersonaFactoryDao {
	public static final int POSTGRESQL_FACTORY = 1;

	public static PersonaFactoryDao getFactory(int claveFactory) {
		switch (claveFactory) {
		case POSTGRESQL_FACTORY:
			return new PostgreSQLPersonaFactoryDao();
		default: 
			return null;
		}
	}

	public abstract PersonaDao getPersonaDAO();
}

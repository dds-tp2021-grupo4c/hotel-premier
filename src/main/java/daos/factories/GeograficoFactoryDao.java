package daos.factories;

import daos.interfaces.GeograficoDao;

public abstract class GeograficoFactoryDao {
	public static final int POSTGRESQL_FACTORY = 1;

	public static GeograficoFactoryDao getFactory(int claveFactory) {
		switch (claveFactory) {
		case POSTGRESQL_FACTORY:
			return new PostgreSQLGeograficoFactoryDao();
		default: 
			return null;
		}
	}

	public abstract GeograficoDao getGeograficoDAO();
}

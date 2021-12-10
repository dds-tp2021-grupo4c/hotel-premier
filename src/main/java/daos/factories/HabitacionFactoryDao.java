package daos.factories;

import daos.interfaces.HabitacionDao;

public abstract class HabitacionFactoryDao {
	public static final int POSTGRESQL_FACTORY = 1;

	public static HabitacionFactoryDao getFactory(int claveFactory) {
		switch (claveFactory) {
		case POSTGRESQL_FACTORY:
			return new PostgreSQLHabitacionFactoryDao();
		default: 
			return null;
		}
	}

	public abstract HabitacionDao getHabitacionDAO();
}

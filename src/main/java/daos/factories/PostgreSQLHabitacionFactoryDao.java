package daos.factories;

import daos.interfaces.HabitacionDao;
import daos.interfaces.implementaciones.HabitacionPostgreSQLDao;

public class PostgreSQLHabitacionFactoryDao extends HabitacionFactoryDao{
	@Override
	public HabitacionDao getHabitacionDAO() {
		return new HabitacionPostgreSQLDao();
	}
}

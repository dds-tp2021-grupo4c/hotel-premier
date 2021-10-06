package daos.factories;

import daos.interfaces.GeograficoDao;
import daos.interfaces.implementaciones.GeograficoPostgreSQLDao;

public class PostgreSQLGeograficoFactoryDao extends GeograficoFactoryDao {

	@Override
	public GeograficoDao getGeograficoDAO() {
		return new GeograficoPostgreSQLDao();
	}
}

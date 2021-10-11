package daos.interfaces.implementaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import daos.interfaces.GeograficoDao;
import dominio.Localidad;
import util.HibernateUtil;

public class GeograficoPostgreSQLDao implements GeograficoDao {
	private SessionFactory sessionFactory;

	public GeograficoPostgreSQLDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public Localidad getLocalidadById(int localidadID) {
		Session session = sessionFactory.openSession();
		Localidad localidad = session.get(Localidad.class, localidadID);
		session.close();
		return localidad;
	}
}

package daos.interfaces.implementaciones;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import daos.interfaces.GeograficoDao;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;
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

	@Override
	public List<Pais> getPaises() {
		Session session = sessionFactory.openSession();
		Query<Pais> query = session.createQuery("SELECT p FROM Pais p", Pais.class);
		List<Pais> paises = query.list();
		session.close();
		return paises;
	}

	@Override
	public List<Provincia> getProvinciasByIdPais(int paisID) {
		Session session = sessionFactory.openSession();
		Query<Provincia> query = session.createQuery("SELECT pr FROM Provincia pr WHERE pr.pais.id = :id", Provincia.class);
		query.setParameter("id", paisID);
		List<Provincia> provincias = query.list();
		session.close();
		return provincias;
	}

	@Override
	public List<Localidad> getLocalidadesByIdProvincia(int provinciaID) {
		Session session = sessionFactory.openSession();
		Query<Localidad> query = session.createQuery("SELECT l FROM Localidad l WHERE l.provincia.id = :id", Localidad.class);
		query.setParameter("id", provinciaID);
		List<Localidad> localidades = query.list();
		session.close();
		return localidades;
	}
}

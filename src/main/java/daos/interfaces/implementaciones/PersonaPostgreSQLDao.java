package daos.interfaces.implementaciones;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import daos.interfaces.PersonaDao;
import dominio.Pasajero;
import dominio.PosicionFrenteIVA;
import dominio.Profesion;
import dominio.TipoDocumento;
import dtos.BusquedaPasajeroDTO;
import util.HibernateUtil;

public class PersonaPostgreSQLDao implements PersonaDao {
	private SessionFactory sessionFactory;

	public PersonaPostgreSQLDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public boolean existePasajeroConMismoTipoYnumeroDocumento(int tipoDocumentoID, String documento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pasajero> buscarPasajero(BusquedaPasajeroDTO pasajeroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDocumento getTipoDocumentoById(int tipoDocumentoID) {
		Session session = sessionFactory.openSession();
		TipoDocumento tipoDocumento = session.get(TipoDocumento.class, tipoDocumentoID);
		session.close();
		return tipoDocumento;
	}

	@Override
	public PosicionFrenteIVA getPosicionFrenteIVAById(int posicionFrenteIVAID) {
		Session session = sessionFactory.openSession();
		PosicionFrenteIVA posicionFrenteIVA = session.get(PosicionFrenteIVA.class, posicionFrenteIVAID);
		session.close();
		return posicionFrenteIVA;
	}

	@Override
	public Profesion getProfesiondById(int profesionID) {
		Session session = sessionFactory.openSession();
		Profesion profesion = session.get(Profesion.class, profesionID);
		session.close();
		return profesion;
	}

	@Override
	public int save(Pasajero pasajero) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(pasajero);
		session.getTransaction().commit();
		session.close();
		return pasajero.getId();
	}
}

package daos.interfaces.implementaciones;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		Session session = sessionFactory.openSession();
		Query<Pasajero> query = session.createQuery("SELECT p FROM Pasajero p WHERE p.tipoDocumento.id = :id and p.numDocumento = :doc", Pasajero.class);
		query.setParameter("id", tipoDocumentoID);
		query.setParameter("doc", documento);
		Pasajero pasajero = null;
		try {
			pasajero = query.getSingleResult();
		} catch (NoResultException e) {
		}
		session.close();
		return pasajero != null;
	}

	@Override
	public List<Pasajero> buscarPasajeros(BusquedaPasajeroDTO pasajeroDTO) {
		Session session = sessionFactory.openSession();
		String consulta = "SELECT p FROM Pasajero p WHERE p.nombre like :nombre and p.apellido like :apellido ";
		if(!pasajeroDTO.getDocumento().equals("")) consulta += "and p.numDocumento = :doc ";
		if(pasajeroDTO.getTipoDocumentoID() != 0) consulta += "and p.tipoDocumento.id = :tipoDoc";
		Query<Pasajero >query = session.createQuery(consulta, Pasajero.class);
		query.setParameter("nombre", pasajeroDTO.getNombre()+"%");
		query.setParameter("apellido", pasajeroDTO.getApellido()+"%");
		if(!pasajeroDTO.getDocumento().equals("")) query.setParameter("doc", pasajeroDTO.getDocumento());
		if(pasajeroDTO.getTipoDocumentoID() != 0) query.setParameter("tipoDoc", pasajeroDTO.getTipoDocumentoID());
		List<Pasajero> pasajeros = query.list();
		session.close();
		return pasajeros;
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

package daos.interfaces.implementaciones;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import daos.interfaces.PosicionIVADao;

import dominio.PosicionFrenteIVA;
import util.HibernateUtil;

public class PosicionIVASQLDao implements PosicionIVADao {

	@Override
	public List<PosicionFrenteIVA> obtener(){

		List<PosicionFrenteIVA> res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		TypedQuery<PosicionFrenteIVA> hqlQuery = session.createQuery("SELECT ps FROM posicion_frente_iva ps");
		
		res = hqlQuery.getResultList();
		
		session.close();
		
		return res;
	}

	@Override
	public PosicionFrenteIVA obtenerPorId(Integer IdPosicionIVA) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TypedQuery<PosicionFrenteIVA> hqlQuery = session.createQuery("SELECT p FROM posicion_frente_iva p WHERE p.IdPosicionIVA = :id");
		
		hqlQuery.setParameter("id", IdPosicionIVA);
		PosicionFrenteIVA res = hqlQuery.getSingleResult();
		
		session.close();
		
		return res;
	}
}

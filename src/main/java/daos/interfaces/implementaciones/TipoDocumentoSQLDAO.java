package daos.interfaces.implementaciones;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import dominio.TipoDocumento;
import util.HibernateUtil;

public class TipoDocumentoSQLDAO {
	
	//Methods Definitions
	public TipoDocumento obtenerPorId(int id) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    TipoDocumento tipoDocumento =  null;
	
   	tipoDocumento = session.get(TipoDocumento.class, id);
    
   	session.close();
   	
   	return tipoDocumento;
	}

public List<TipoDocumento>obtener(){
	List<TipoDocumento> res;
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	TypedQuery<TipoDocumento> hqlQuery = session.createQuery("SELECT td FROM tipo_documento td");
	res = hqlQuery.getResultList();
	
	session.close();
	
	return res;
}
	
}

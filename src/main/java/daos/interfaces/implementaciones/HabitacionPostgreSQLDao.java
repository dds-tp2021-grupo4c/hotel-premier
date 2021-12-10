package daos.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import daos.interfaces.HabitacionDao;
import dominio.Habitacion;
import dominio.Mantenimiento;
import dominio.Ocupacion;
import dominio.Reserva;
import util.HibernateUtil;

public class HabitacionPostgreSQLDao implements HabitacionDao {

	public HabitacionPostgreSQLDao() {
	}

	@Override
	public List<Habitacion> getHabitaciones() {
		Session session = HibernateUtil.getSession();
		Query<Habitacion> query = session.createQuery("SELECT h FROM Habitacion h", Habitacion.class);
		List<Habitacion> habitaciones = query.list();
		return habitaciones;
	}

	@Override
	public boolean existeReservaByDiaYIdHabitacion(LocalDate fecha, int idHabitacion) {
		Session session = HibernateUtil.getSession();
		Query<Reserva> query = session.createQuery("SELECT r FROM Reserva r WHERE :fecha between r.fechaIngreso and r.fechaEgreso and r.habitacion.id = :id", Reserva.class);
		query.setParameter("fecha", fecha);
		query.setParameter("id", idHabitacion);
		Reserva reserva = null;
		try {
			reserva = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return reserva != null;
	}

	@Override
	public boolean existeOcupacionByDiaYIdHabitacion(LocalDate fecha, int idHabitacion) {
		Session session = HibernateUtil.getSession();
		Query<Ocupacion> query = session.createQuery("SELECT o FROM Ocupacion o WHERE :fecha between o.fechaInicio and o.fechaFin and o.habitacion.id = :id", Ocupacion.class);
		query.setParameter("fecha", fecha);
		query.setParameter("id", idHabitacion);
		Ocupacion ocupacion = null;
		try {
			ocupacion = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return ocupacion != null;
	}

	@Override
	public boolean existeMantenimientoByDiaYIdHabitacion(LocalDate fecha, int idHabitacion) {
		Session session = HibernateUtil.getSession();
		Query<Mantenimiento> query = session.createQuery("SELECT m FROM Mantenimiento m WHERE :fecha between m.fechaDesde and m.fechaHasta and m.habitacion.id = :id", Mantenimiento.class);
		query.setParameter("fecha", fecha);
		query.setParameter("id", idHabitacion);
		Mantenimiento mantenimiento = null;
		try {
			mantenimiento = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return mantenimiento != null;
	}
}

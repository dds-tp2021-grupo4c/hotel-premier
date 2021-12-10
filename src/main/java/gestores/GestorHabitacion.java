package gestores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import daos.factories.HabitacionFactoryDao;
import daos.interfaces.HabitacionDao;
import dominio.Habitacion;
import dtos.BusquedaHabitacionesDTO;
import dtos.HabitacionDTO;

public final class GestorHabitacion {
	private static GestorHabitacion instancia;
	private HabitacionFactoryDao habitacionFactory;
	private HabitacionDao habitacionDao;

	private GestorHabitacion() {
	}

	public synchronized static GestorHabitacion getInstance() {
		if(instancia == null)
			instancia= new GestorHabitacion();
		return instancia;
	}

	private boolean validarFechas(BusquedaHabitacionesDTO busqHabitacionesDTO) {
		if(busqHabitacionesDTO.getFechaDesde() == null || busqHabitacionesDTO.getFechaHasta() == null) {
			return false;
		} else if(busqHabitacionesDTO.getFechaDesde().compareTo(busqHabitacionesDTO.getFechaHasta()) > 0){
			return false;
		}
		else return true;
	}

	public List<HabitacionDTO> buscarHabitacionesPorRangoFechas(BusquedaHabitacionesDTO busqHabtDTO){
		habitacionFactory = HabitacionFactoryDao.getFactory(HabitacionFactoryDao.POSTGRESQL_FACTORY);
		habitacionDao = habitacionFactory.getHabitacionDAO();
		boolean esValido = validarFechas(busqHabtDTO);
		if(!esValido) return null;
		List<Habitacion> habitaciones = habitacionDao.getHabitaciones();
		List<HabitacionDTO> listaHabitacionesDTO = new ArrayList<HabitacionDTO>();
		for(Habitacion unaHabitacion : habitaciones) {
			HabitacionDTO h = new HabitacionDTO();
			h.setIdHabitacion(unaHabitacion.getId());
			h.setNumeroHabitacion(unaHabitacion.getNumero());
			h.setTipoHabitacion(unaHabitacion.getTipo().getNombre());
			LocalDate fecha = busqHabtDTO.getFechaDesde();
			while(ChronoUnit.DAYS.between(fecha,busqHabtDTO.getFechaHasta()) >= 0) {
				boolean existeReserva = habitacionDao.existeReservaByDiaYIdHabitacion(fecha, unaHabitacion.getId());
				boolean existeOcupacion = habitacionDao.existeOcupacionByDiaYIdHabitacion(fecha, unaHabitacion.getId());
				boolean existeMantenimiento = habitacionDao.existeMantenimientoByDiaYIdHabitacion(fecha, unaHabitacion.getId());
				if(existeReserva) h.addEstado("RESERVADA");
				else if(existeOcupacion) h.addEstado("OCUPADA");
				else if(existeMantenimiento) h.addEstado("FUERA DE SERVICIO");
				else h.addEstado("LIBRE");
				fecha = fecha.plus(1, ChronoUnit.DAYS);
			}
			listaHabitacionesDTO.add(h);
		}
		return listaHabitacionesDTO;
	}
}

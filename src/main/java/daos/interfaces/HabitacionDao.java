package daos.interfaces;

import java.time.LocalDate;
import java.util.List;

import dominio.Habitacion;

public interface HabitacionDao {
	public List<Habitacion> getHabitaciones();
	public boolean existeReservaByDiaYIdHabitacion(LocalDate fecha, int idHabitacion);
	public boolean existeOcupacionByDiaYIdHabitacion(LocalDate fecha, int idHabitacion);
	public boolean existeMantenimientoByDiaYIdHabitacion(LocalDate fecha, int idHabitacion);
}

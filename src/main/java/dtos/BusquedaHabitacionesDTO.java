package dtos;

import java.time.LocalDate;

public class BusquedaHabitacionesDTO {
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;

	public BusquedaHabitacionesDTO(LocalDate fechaDesde, LocalDate fechaHasta) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}
}

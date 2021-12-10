package dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ocupacion")
public class Ocupacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

	@Column(name = "fecha_fin")
	private LocalDate fechaFin;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_responsable", referencedColumnName = "id")
	private Pasajero responsable;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "tiene_acompaniantes",
			joinColumns = @JoinColumn(name = "id_ocupacion", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_pasajero", referencedColumnName = "id")
	)
	private List<Pasajero> acompaniantes;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_habitacion", referencedColumnName = "id")
	private Habitacion habitacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Pasajero getResponsable() {
		return responsable;
	}

	public void setResponsable(Pasajero responsable) {
		this.responsable = responsable;
	}

	public List<Pasajero> getAcompaniantes() {
		return acompaniantes;
	}

	public void setAcompaniantes(List<Pasajero> acompaniantes) {
		this.acompaniantes = acompaniantes;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
}

package dominio;

import javax.persistence.JoinColumn;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;

	@Column
	private int numero;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_estado", referencedColumnName = "id")
	private EstadoHabitacion estado;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo", referencedColumnName = "id")
	private TipoHabitacion tipo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "posee",
			joinColumns = @JoinColumn(name = "id_habitacion", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_costo", referencedColumnName = "id")
	)
	private List<Costo> costo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public EstadoHabitacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoHabitacion estado) {
		this.estado = estado;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
}

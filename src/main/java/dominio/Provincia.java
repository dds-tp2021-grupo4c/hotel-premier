package dominio;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pais", referencedColumnName = "id")
	private Pais pais;

	@OneToMany(mappedBy = "provincia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Localidad> localidades;

	public Provincia(int id, String nombre, Pais pais, List<Localidad> localidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.localidades = localidades;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public List<Localidad> getLocalidades(){
		return localidades;
	}
}

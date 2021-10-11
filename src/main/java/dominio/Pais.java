package dominio;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@OneToMany(mappedBy = "pais", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Provincia> provincias;

	public Pais(int id, String nombre, List<Provincia> provincias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincias = provincias;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Provincia> getProvincias(){
		return provincias;
	}
}

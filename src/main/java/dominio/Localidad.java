package dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="localidad")
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@Column(name = "codigo_postal")
	private String codigoPostal;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_provincia", referencedColumnName = "id")
	private Provincia provincia;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public Provincia getProvincia() {
		return provincia;
	}
}

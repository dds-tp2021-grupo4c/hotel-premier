package dominio;

import java.util.List;

public class Provincia {
	private int id;
	private String nombre;
	private Pais pais;
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

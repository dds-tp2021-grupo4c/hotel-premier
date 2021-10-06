package dominio;

import java.util.List;

public class Pais {
	private int id;
	private String nombre;
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

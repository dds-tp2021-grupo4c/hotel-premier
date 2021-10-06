package dominio;

public class Profesion {
	private int id;
	private String nombre;

	public Profesion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}

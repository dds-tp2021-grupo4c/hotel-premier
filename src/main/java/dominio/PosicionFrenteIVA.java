package dominio;

public class PosicionFrenteIVA {
	private int id;
	private String nombre;

	public PosicionFrenteIVA(int id, String nombre) {
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

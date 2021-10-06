package dominio;

public class TipoDocumento {
	private int id;
	private String nombre;

	public TipoDocumento(int id, String nombre) {
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

package dominio;

public class Localidad {
	private int id;
	private String nombre;
	private String codigoPostal;
	private Provincia provincia;

	public Localidad(int id, String nombre, String codigoPostal, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
	}

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

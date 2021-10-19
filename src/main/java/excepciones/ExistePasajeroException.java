package excepciones;

@SuppressWarnings("serial")
public class ExistePasajeroException extends Exception{
	public ExistePasajeroException() {
		super("Existe pasajero con el mismo tipo y numero de documento");
	}
}

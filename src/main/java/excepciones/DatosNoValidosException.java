package excepciones;

@SuppressWarnings("serial")
public class DatosNoValidosException extends Exception {
	public DatosNoValidosException() {
		super("Hay datos que no son validos");
	}
}

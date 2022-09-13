
public class NoNumericException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NoNumericException() {
		super("The password must contain at least 1 numeric character");
	}

}

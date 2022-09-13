
public class LengthException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LengthException() {
		super("password must be at least 6 characters");
	}

}


public class NoSpecialCharacterException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSpecialCharacterException() {
		super("The password must contain a special character");
	}

}

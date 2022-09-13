
public class hasRepeatingException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public hasRepeatingException() {
		super("The password cannot have two repeating characters");
	}

}

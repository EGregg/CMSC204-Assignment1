
public class NoLowerAlphaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoLowerAlphaException() {
		super("The password must contain a lower case character");
	}

}

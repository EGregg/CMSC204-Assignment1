
public class NoUpperAlphaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUpperAlphaException() {
		super("The password must contain an uppercase character");
	}

}

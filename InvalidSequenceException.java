
public class InvalidSequenceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSequenceException() {
		super ("password is an invalid sequence");
	}

}

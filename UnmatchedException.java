
public class UnmatchedException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnmatchedException() {
		super("The password and confirmation password must be the same"); 
	}
}

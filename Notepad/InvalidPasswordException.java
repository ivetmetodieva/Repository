
public class InvalidPasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(){
		super("The password IS INCORRECT.");
	}
}

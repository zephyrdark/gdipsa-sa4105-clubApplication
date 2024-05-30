package clubApplication;

public class BadBookingException extends Exception {
	
	/**
	 * auto generated
	 */
	private static final long serialVersionUID = 1106525001693952937L;

	public String message;
	
	public BadBookingException() {
		super();
	}
	
	public BadBookingException(String message) {
		super(message);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}

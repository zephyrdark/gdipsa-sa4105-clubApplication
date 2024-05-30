package clubApplication;

public class BadBookingException extends Exception {
	
	public BadBookingException() {
		super();
	}
	
	public BadBookingException(String message) {
		super(message);
	}
}

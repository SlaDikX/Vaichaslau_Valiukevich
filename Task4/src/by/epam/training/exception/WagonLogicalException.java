package by.epam.training.exception;

public class WagonLogicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WagonLogicalException() {
	}

	public WagonLogicalException(String message) {
		super(message);
	}

	public WagonLogicalException(Throwable exception) {
		super(exception);
	}

	public WagonLogicalException(String message, Throwable exception) {
		super(message, exception);
	}
}

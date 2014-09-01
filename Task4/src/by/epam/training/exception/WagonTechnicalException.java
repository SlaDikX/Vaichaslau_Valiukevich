package by.epam.training.exception;

public class WagonTechnicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WagonTechnicalException() {
		super();
	}

	public WagonTechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public WagonTechnicalException(String message) {
		super(message);
	}

	public WagonTechnicalException(Throwable cause) {
		super(cause);
	}

}

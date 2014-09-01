package by.epam.training.exception;

public class ControllerTechnicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerTechnicalException() {
		super();
	}

	public ControllerTechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerTechnicalException(String message) {
		super(message);
	}

	public ControllerTechnicalException(Throwable cause) {
		super(cause);
	}

}

package by.epam.training.exception;

public class CoffeeLogicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoffeeLogicalException() {
		super();
	}

	public CoffeeLogicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoffeeLogicalException(String message) {
		super(message);
	}

	public CoffeeLogicalException(Throwable cause) {
		super(cause);
	}

}

package by.epam.training.exception;

public class WagonBuilderLogicalException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WagonBuilderLogicalException() {
		super();
	}

	public WagonBuilderLogicalException(String message, Throwable cause) {
		super(message, cause);
		}

	public WagonBuilderLogicalException(String message) {
		super(message);
	}

	public WagonBuilderLogicalException(Throwable cause) {
		super(cause);
	}

}

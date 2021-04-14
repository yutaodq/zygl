package mike.wolf.zygl.adapter.persistence.exception;

public abstract class ApplicationException extends RuntimeException {
	public ApplicationException(String message) {
		super(message);
	}
}

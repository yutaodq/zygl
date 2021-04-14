package mike.wolf.zygl.adapter.persistence.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(String.format("没有查找到 %d 的记录", message));
	}

	public static NotFoundException from(String message) {
		return new NotFoundException(message);
	}
}

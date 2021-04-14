package mike.wolf.zygl.adapter.persistence.exception;

public class DuplicatedNameException extends ApplicationException {
	public DuplicatedNameException(String name) {
		super(String.format("重复的名称 %s", name));
	}
}

package develop.framework.commons.exceptions;

/**
 * 范围异常
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 * @see develop.framework.commons.components.Range
 */
public class RangeException extends BusinessException{

	public RangeException(String message) {
		super(message);
	}

	public RangeException(String format, Object... parameters) {
		super(format, parameters);
	}
}

package develop.framework.commons.exceptions;

import develop.framework.commons.enums.Level;

/**
 * 意外的异常
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class UnexpectedException extends FrameworkException {

    public UnexpectedException(Throwable cause, String message) {
        super(Level.DANGEROUS, message, cause);
    }

    public UnexpectedException(Throwable cause, String format, Object... parameters) {
        super(Level.DANGEROUS, format, cause, parameters);
    }

    public UnexpectedException(Throwable anyThrowable) {
        this(anyThrowable.getCause(), anyThrowable.getMessage());
    }
}

package develop.framework.commons.exceptions;

import develop.framework.commons.enums.Level;

/**
 * 意外的异常
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class UnexpectedException extends FrameworkException{

    public UnexpectedException(String message, Throwable cause) {
        super(Level.DANGEROUS, message, cause);
    }

    public UnexpectedException(String format, Throwable cause, Object... parameters) {
        super(Level.DANGEROUS, format, cause, parameters);
    }

    public UnexpectedException(Throwable anyThrowable) {
        this(anyThrowable.getMessage(), anyThrowable.getCause());
    }
}

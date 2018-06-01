package develop.framework.commons.exceptions;

import develop.framework.commons.enums.Level;
import lombok.Getter;

/**
 * 异常基类
 *
 * @author qiushui on 2018-05-24.
 * @version 0.1
 */
public abstract class FrameworkException extends FormatRuntimeException{

    @Getter
    protected Level level;

    public FrameworkException(Level level, String message) {
        super(message);
        this.level = level;
    }

    public FrameworkException(Level level, String format, Object... parameters) {
        super(format, parameters);
        this.level = level;
    }

    public FrameworkException(Level level, String message, Throwable cause) {
        super(message, cause);
        this.level = level;
    }

    public FrameworkException(Level level, String format, Throwable cause, Object... parameters) {
        super(format, cause, parameters);
        this.level = level;
    }
}

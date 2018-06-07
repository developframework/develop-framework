package develop.framework.application.web;

import com.github.developframework.kite.spring.mvc.response.KiteResponse;
import develop.framework.application.web.kite.res.ErrorReasonKiteResponse;
import develop.framework.application.web.kite.res.ErrorKiteResponse;
import develop.framework.application.web.kite.res.ValidatedKiteResponse;
import develop.framework.commons.enums.Level;
import develop.framework.commons.exceptions.BusinessException;
import develop.framework.commons.exceptions.FrameworkException;
import develop.framework.commons.exceptions.UnexpectedException;
import develop.framework.commons.exceptions.ValidatedArgumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 框架处理所有异常
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
@Slf4j
@ControllerAdvice
public class FrameworkControllerAdvice {

    /**
     * 业务异常处理
     * @param businessException 业务异常
     * @return 带错误原因的响应体
     * @see ErrorReasonKiteResponse
     */
    @ExceptionHandler(BusinessException.class)
    public KiteResponse businessException(BusinessException businessException) {
        return new ErrorReasonKiteResponse(businessException);
    }

    /**
     * 参数验证异常处理
     *
     * @param validatedArgumentException 参数验证异常
     * @return 参数验证错误响应体
     * @see ValidatedKiteResponse
     */
    @ExceptionHandler(ValidatedArgumentException.class)
    public KiteResponse validatedArgumentException(ValidatedArgumentException validatedArgumentException) {
        return new ValidatedKiteResponse(validatedArgumentException);
    }

    /**
     * 意外的异常处理
     *
     * @param unexpectedException 意外的异常
     * @return 错误响应体
     * @see ErrorKiteResponse
     */
    @ExceptionHandler(UnexpectedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public KiteResponse unexpectedException(UnexpectedException unexpectedException) {
        log.warn("[ {} ] {}", unexpectedException.getLevel().name(), unexpectedException.getMessage());
        return new ErrorKiteResponse(unexpectedException.getLevel(), unexpectedException.getMessage());
    }

    /**
     * 框架其它异常处理
     *
     * @param frameworkException 框架其它异常
     * @return 错误响应体
     * @see ErrorKiteResponse
     */
    @ExceptionHandler(FrameworkException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public KiteResponse frameworkException(FrameworkException frameworkException) {
        log.error("[ {} ] {}", frameworkException.getLevel().name(), frameworkException.getMessage());
        return new ErrorKiteResponse(frameworkException.getLevel(), frameworkException.getMessage());
    }

    /**
     * 任意异常或错误处理
     *
     * @param throwable 任意异常或错误
     * @return 错误响应体
     * @see ErrorKiteResponse
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public KiteResponse anyThrowable(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return new ErrorKiteResponse(Level.FATAL, throwable.getMessage());
    }
}

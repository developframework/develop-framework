package develop.framework.application.web.kite.res;

import develop.framework.commons.enums.Level;
import develop.framework.commons.exceptions.BusinessException;
import develop.framework.components.KeyValuePair;

import java.util.List;

/**
 * 带错误原因的响应体
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class ErrorReasonKiteResponse extends ErrorKiteResponse{

    public ErrorReasonKiteResponse(Level level, String message, List<KeyValuePair<String, Object>> reasons) {
        super("error-reason-res", level, message);
        if(reasons != null && !reasons.isEmpty()) {
            this.dataModel.putData("reasons", reasons);
        }
    }

    public ErrorReasonKiteResponse(BusinessException businessException) {
        this(businessException.getLevel(), businessException.getMessage(), businessException.getReasons());
    }
}

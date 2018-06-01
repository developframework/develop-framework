package develop.framework.application.web.kite.res;

import com.github.developframework.kite.spring.mvc.response.EmptyKiteResponse;
import develop.framework.commons.enums.Level;

/**
 * 错误信息响应体
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class ErrorKiteResponse extends EmptyKiteResponse {

    public ErrorKiteResponse(String templateId, Level level, String message) {
        super("kite-application-web", templateId);
        this.dataModel.putData("message", message);
        this.dataModel.putData("level", level);
    }

    public ErrorKiteResponse(Level level, String message) {
        this("error-res", level, message);
    }
}

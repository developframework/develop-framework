package develop.framework.application.web.kite.res;

import develop.framework.commons.exceptions.ValidatedArgumentException;

/**
 * 参数验证错误响应体
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class ValidatedKiteResponse extends ErrorKiteResponse{

    public ValidatedKiteResponse(ValidatedArgumentException validatedArgumentException) {
        super("error-validate-res", validatedArgumentException.getLevel(), validatedArgumentException.getMessage());
        this.dataModel.putData("hints", validatedArgumentException.getHints());
    }
}

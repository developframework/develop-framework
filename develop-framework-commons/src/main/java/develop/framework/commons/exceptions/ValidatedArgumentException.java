package develop.framework.commons.exceptions;

import develop.framework.commons.components.KeyValuePair;
import develop.framework.commons.enums.Level;
import lombok.Getter;

import java.util.List;

/**
 * 验证参数异常
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class ValidatedArgumentException extends FrameworkException {

    @Getter
    private List<KeyValuePair<String, String>> hints;

    public ValidatedArgumentException(List<KeyValuePair<String, String>> hints) {
        super(Level.NORMAL, "argument validate failed");
        this.hints = hints;
    }
}

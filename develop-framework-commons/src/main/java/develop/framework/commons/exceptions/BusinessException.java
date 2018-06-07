package develop.framework.commons.exceptions;

import develop.framework.commons.enums.Level;
import develop.framework.commons.components.KeyValuePair;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * 因为业务原因而导致的异常
 *
 * @author qiushui on 2018-05-24.
 * @version 0.1
 */
public class BusinessException extends FrameworkException {

    @Getter
    protected List<KeyValuePair<String, Object>> reasons = new LinkedList<>();

    public BusinessException(String message) {
        super(Level.NORMAL, message);
    }

    public BusinessException(String format, Object... parameters) {
        super(Level.NORMAL, format, parameters);
    }

    /**
     * 添加原因
     * @param reasonName 原因值名称
     * @param value 值
     * @return 返回自己，链式写法
     */
    public BusinessException addReason(String reasonName, Object value) {
        reasons.add(new KeyValuePair<>(reasonName, value));
        return this;
    }
}

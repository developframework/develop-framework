package develop.framework.application.web;

import develop.framework.commons.exceptions.UnexpectedException;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;

/**
 * 提交内容
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public interface Body {

    /**
     * 转化到某个实体类
     * @param targetClass 目标类型
     * @param <T> 目标类型
     * @return 目标实体
     */
    default <T> T transform(Class<T> targetClass) {
        try {
            Constructor<T> constructor = targetClass.getConstructor();
            T target = constructor.newInstance();
            BeanUtils.copyProperties(this, target);
            return target;
        } catch (Exception e) {
            throw new UnexpectedException(e, "%s transform to %s failed", this.getClass().getName(), targetClass.getName());
        }
    }
}

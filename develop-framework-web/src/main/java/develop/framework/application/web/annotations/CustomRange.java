package develop.framework.application.web.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义范围注解
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface CustomRange {

	String value();

	String fromKey();

	String toKey();
}

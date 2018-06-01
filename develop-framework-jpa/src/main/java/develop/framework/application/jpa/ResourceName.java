package develop.framework.application.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 资源名称注解
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ResourceName {

    String value();

    String kiteNamespace();

    String detailKiteTemplateId() default "detail";

}

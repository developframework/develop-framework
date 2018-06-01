package develop.framework.application.web.kite;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.github.developframework.kite.core.dynamic.PropertyConverter;

/**
 * 字段下划线转换器
 *
 * @author qiushui on 2018-05-30.
 * @since 0.1
 */
public class FieldNameConverter implements PropertyConverter<String> {


    @Override
    public String convert(Object source) {
        return SnakeCaseStrategy.SNAKE_CASE.nameForField(null, null, (String) source);
    }
}

package develop.framework.commons.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Jackson对于金额的处理
 * 处理成以分为单位的整型数值
 *
 * @author qiushui on 2018-05-26.
 * @version 0.1
 */
public class CustomMoneyDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return jsonParser.getIntValue() * 100;
    }
}

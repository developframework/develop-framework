package develop.framework.application.web.controller;

import develop.framework.commons.exceptions.ValidatedArgumentException;
import develop.framework.components.KeyValuePair;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 可验证参数的控制器基类
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public abstract class VerifiableController {

    protected void validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<KeyValuePair<String, String>> hints = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> new KeyValuePair<>(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
            throw new ValidatedArgumentException(hints);
        }
    }
}

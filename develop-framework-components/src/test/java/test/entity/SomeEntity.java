package test.entity;

import develop.framework.components.EntitySign;
import develop.framework.components.Extractable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qiushui on 2018-06-03.
 * @since 0.1
 */
@Data
@AllArgsConstructor
public class SomeEntity implements EntitySign<String>, Extractable<String> {

	private String someKey;

	@Override
	public String key() {
		return someKey;
	}

	@Override
	public boolean accept(String parameter) {
		return someKey.equals(parameter);
	}
}

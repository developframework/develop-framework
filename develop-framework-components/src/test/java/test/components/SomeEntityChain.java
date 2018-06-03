package test.components;

import develop.framework.components.EntityChain;
import test.entity.SomeEntity;

/**
 * @author qiushui on 2018-06-03.
 * @since 0.1
 */
public class SomeEntityChain extends EntityChain<SomeEntity, String> {
	@Override
	protected SomeEntity[] defaultEntity() {
		return new SomeEntity[] {
				new SomeEntity("default")
		};
	}
}

package test.components;

import develop.framework.components.EntityRegistry;
import test.entity.SomeEntity;

/**
 * @author qiushui on 2018-06-03.
 * @since 0.1
 */
public class SomeEntityRegistry extends EntityRegistry<SomeEntity, String> {

	@Override
	protected SomeEntity[] defaultEntity() {
		return new SomeEntity[] {
				new SomeEntity("default")
		};
	}
}

package test;

import develop.framework.components.EntityRegistry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import test.components.SomeEntityRegistry;
import test.entity.SomeEntity;

import java.util.Optional;

/**
 * @author qiushui on 2018-06-03.
 * @since 0.1
 */
public class EntityRegistryTest {

	private EntityRegistry<SomeEntity, String> entityRegistry;

	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Before
	public void init() {
		entityRegistry = new SomeEntityRegistry();
	}

	@Test
	public void testAddAndExtract() {
		SomeEntity someEntity = new SomeEntity("abc");
		entityRegistry.addCustomEntities(new SomeEntity[] {
				someEntity
		});
		Optional<SomeEntity> entityOptional = entityRegistry.extract("default");
		Assert.assertTrue(entityOptional.isPresent());

		final String fallbackValue = "fallback";
		SomeEntity entity = entityRegistry.extractOrDefault("123", new SomeEntity(fallbackValue));
		Assert.assertEquals(entity.getSomeKey(), fallbackValue);

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("456");
		entityRegistry.extractRequired("123", new RuntimeException("456"));
	}
}

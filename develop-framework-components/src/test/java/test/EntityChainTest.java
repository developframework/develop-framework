package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import test.components.SomeEntityChain;
import test.entity.SomeEntity;

import java.util.Optional;

/**
 * @author qiushui on 2018-06-03.
 * @since 0.1
 */
public class EntityChainTest {

	private SomeEntityChain someEntityChain;

	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Before
	public void init() {
		someEntityChain = new SomeEntityChain();
	}

	@Test
	public void testAddAndExtract() {
		SomeEntity someEntity = new SomeEntity("abc");
		someEntityChain.addCustomEntities(new SomeEntity[] {
				someEntity
		});
		Optional<SomeEntity> entityOptional = someEntityChain.extract("default");
		Assert.assertTrue(entityOptional.isPresent());

		final String fallbackValue = "fallback";
		SomeEntity entity = someEntityChain.extractOrDefault("123", new SomeEntity(fallbackValue));
		Assert.assertEquals(entity.getSomeKey(), fallbackValue);

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("456");
		someEntityChain.extractRequired("123", new RuntimeException("456"));
	}
}

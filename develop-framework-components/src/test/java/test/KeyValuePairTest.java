package test;

import develop.framework.components.KeyValuePair;
import org.junit.Assert;
import org.junit.Test;

/**
 * KeyValuePair单元测试
 *
 * @author qiushui on 2018-06-03.
 * @since 0.2
 */
public class KeyValuePairTest {

	@Test
	public void testEquals() {
		KeyValuePair<String, String> target = new KeyValuePair<>("key", "value");
		KeyValuePair<String, String> otherTarget = new KeyValuePair<>("key", "value");
		Assert.assertTrue(target.equals(otherTarget));

		KeyValuePair<String, String> nullTarget = new KeyValuePair<>(null, null);
		KeyValuePair<String, String> otherNullTarget = new KeyValuePair<>(null, null);
		Assert.assertTrue(nullTarget.equals(otherNullTarget));
	}
}

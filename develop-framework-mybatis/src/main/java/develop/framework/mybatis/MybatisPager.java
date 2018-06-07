package develop.framework.mybatis;

import develop.framework.commons.components.Pager;
/**
 * Mybatis版的Pager
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
public class MybatisPager extends Pager{

	public MybatisPager() {
		super();
	}

	public MybatisPager(int index, int size) {
		super(index, size);
	}

	/**
	 * 生成 LIMIT 语句
	 * @return LIMIT 语句
	 */
	public String limitSQL() {
		return String.format("LIMIT %d, %d", (index - 1) * size, size);
	}
}

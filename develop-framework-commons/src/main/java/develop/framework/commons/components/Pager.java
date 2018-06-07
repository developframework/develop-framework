package develop.framework.commons.components;

import lombok.Getter;

/**
 * 分页请求参数信息
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
public abstract class Pager {

	public static final int DEFAULT_INDEX = 1;
	public static final int DEFAULT_SIZE = 10;

	/* 页码 */
	@Getter
	protected int index;
	/* 页容量 */
	@Getter
	protected int size;

	public Pager() {
		this(DEFAULT_INDEX, DEFAULT_SIZE);
	}

	public Pager(int index, int size) {
		this.index = index;
		this.size = size;
	}
}

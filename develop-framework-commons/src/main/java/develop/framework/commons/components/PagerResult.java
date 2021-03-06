package develop.framework.commons.components;

import lombok.Getter;

import java.util.List;

/**
 * 分页列表结果
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
@Getter
public class PagerResult<T> {

	/* 数据列表 */
	private List<T> list;

	/* 记录总条数 */
	private int total;

	/* 分页信息 */
	private Pager pager;

	/* 页总数 */
	private int pageTotal;

	public PagerResult(Pager pager, List<T> list, int total) {
		this.list = list;
		this.total = total;
		this.pager = pager;
		this.pageTotal = total % pager.getSize() == 0 ? total / pager.getSize() : (total / pager.getSize() + 1);
	}

	public PagerResult(int index, int size, List<T> list, int total) {
		this(new SimplePager(index, size), list, total);
	}
}

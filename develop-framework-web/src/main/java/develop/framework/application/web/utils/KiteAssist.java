package develop.framework.application.web.utils;

import com.github.developframework.kite.core.data.DataModel;
import com.github.developframework.kite.core.data.DataModelBuilder;
import com.github.developframework.kite.core.data.HashDataModel;
import develop.framework.application.web.kite.res.PagerKiteResponse;
import develop.framework.commons.components.Pager;
import develop.framework.commons.components.PagerResult;

import java.util.List;

/**
 * Kite代码辅助类
 *
 * @author qiushui on 2018-07-09.
 * @since 0.4
 */
public final class KiteAssist {

	/**
	 * 生成带success的DataModelBuilder
	 *
	 * @return
	 */
	public static DataModelBuilder dataModel() {
		return HashDataModel.builder()
				.put("success", true);
	}

	/**
	 * 生成带success的单一DataModel
	 *
	 * @return
	 */
	public static DataModel dataModelForSingleton(String dataName, Object value) {
		return HashDataModel.builder()
				.put("success", true)
				.put(dataName, value)
				.build();
	}

	/**
	 * 根据Pager生成PagerKiteResponse
	 * @return
	 */
	public static <T> PagerKiteResponse<T> responseForPager(Pager pager, List<T> list, int total) {
		return responseForPager(null, null, pager, list, total);
	}

	/**
	 * 根据Pager生成PagerKiteResponse
	 * @return
	 */
	public static <T> PagerKiteResponse<T> responseForPager(String namespace, String templateId, Pager pager, List<T> list, int total) {
		PagerResult<T> pagerResult = new PagerResult<>(pager, list, total);
		return new PagerKiteResponse<>(namespace, templateId, pagerResult);
	}

	/**
	 * 根据Pageable生成PagerKiteResponse
	 * @return
	 */
	public static <T> PagerKiteResponse<T> responseForPageable(int index, int size, List<T> list, int total) {
		return responseForPageable(null, null, index, size, list, total);
	}

	/**
	 * 根据Pageable生成PagerKiteResponse
	 * @return
	 */
	public static <T> PagerKiteResponse<T> responseForPageable(String namespace, String templateId, int index, int size, List<T> list, int total) {
		PagerResult<T> pagerResult = new PagerResult<>(index, size, list, total);
		return new PagerKiteResponse<>(namespace, templateId, pagerResult);
	}
}

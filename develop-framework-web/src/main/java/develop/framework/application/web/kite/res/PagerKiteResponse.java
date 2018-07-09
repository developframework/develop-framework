package develop.framework.application.web.kite.res;

import com.github.developframework.kite.spring.mvc.response.EmptyKiteResponse;
import develop.framework.commons.components.PagerResult;

/**
 * 分页Kite响应体
 *
 * @author qiushui on 2018-06-07.
 * @since 0.3
 */
public class PagerKiteResponse<T> extends EmptyKiteResponse {

	public PagerKiteResponse(String namespace, String templateId, PagerResult<T> pagerResult) {
		super(namespace, templateId);
		this.dataModel.putData("success", true);
		this.dataModel.putData("pagerResult", pagerResult);
	}
}

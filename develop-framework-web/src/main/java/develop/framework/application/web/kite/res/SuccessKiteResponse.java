package develop.framework.application.web.kite.res;

import com.github.developframework.kite.spring.mvc.response.EmptyKiteResponse;

/**
 * @author qiushui on 2018-07-09.
 * @since 0.4
 */
public class SuccessKiteResponse extends EmptyKiteResponse {

	public SuccessKiteResponse() {
		super();
		this.dataModel.putData("success", true);
	}

	public SuccessKiteResponse(String namespace, String templateId) {
		super(namespace, templateId);
		this.dataModel.putData("success", true);
	}
}

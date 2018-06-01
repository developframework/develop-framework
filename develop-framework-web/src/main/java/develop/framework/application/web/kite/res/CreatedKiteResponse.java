package develop.framework.application.web.kite.res;

import com.github.developframework.kite.spring.mvc.response.EmptyKiteResponse;

/**
 * 创建资源成功响应体
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class CreatedKiteResponse extends EmptyKiteResponse {

    public CreatedKiteResponse(int id) {
        super("kite-application-web", "created-res");
        this.dataModel.putData("id", id);
    }
}

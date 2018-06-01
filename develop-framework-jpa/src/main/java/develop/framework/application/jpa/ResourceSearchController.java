package develop.framework.application.jpa;

import com.github.developframework.kite.spring.mvc.response.EmptyKiteResponse;
import com.github.developframework.kite.spring.mvc.response.KiteResponse;
import develop.framework.commons.exceptions.BusinessException;
import develop.framework.commons.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * 资源检索控制器
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
@Controller
@RequestMapping("{resourceName}")
public class ResourceSearchController {

    private static final String RESOURCE_KEY = "resource";

    @Autowired
    private List<BaseRepository> baseRepositories;

    @SuppressWarnings("unchecked")
    @GetMapping("{id}")
    public KiteResponse resourceDetailById(@PathVariable String resourceName, @PathVariable Long id) {
        for (BaseRepository baseRepository : baseRepositories) {
            if (baseRepository.support(resourceName)) {
                Class<?> domainClass = baseRepository.getDomainClass();
                ResourceName annotation = AnnotationUtils.findAnnotation(domainClass, ResourceName.class);
                Optional<?> resourceOptional = baseRepository.findById(id);
                KiteResponse kiteResponse = new EmptyKiteResponse(annotation.kiteNamespace(), annotation.detailKiteTemplateId());
                kiteResponse.getDataModel().putData(RESOURCE_KEY, Assert.resourceExist(resourceName, resourceOptional));
                return kiteResponse;
            }
        }
        throw new BusinessException("There is no such resource \"%s\".", resourceName);
    }
}

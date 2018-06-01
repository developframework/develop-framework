package develop.framework.application.jpa;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 基类实现类
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private Class<T> domainClass;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.domainClass = domainClass;
    }

    @Override
    public boolean support(String resourceName) {
        if (AnnotationUtils.isAnnotationDeclaredLocally(ResourceName.class, domainClass)) {
            return AnnotationUtils.findAnnotation(domainClass, ResourceName.class).value().equals(resourceName);
        }
        return false;
    }

    @Override
    public Class<T> getDomainClass() {
        return domainClass;
    }
}

package develop.framework.application.jpa;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 基本Repository工厂
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public class BaseRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

    private final EntityManager em;

    public BaseRepositoryFactory(EntityManager em) {
        super(em);
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Object getTargetRepository(RepositoryInformation information) {
        return new BaseRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), em);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseRepositoryImpl.class;
    }
}

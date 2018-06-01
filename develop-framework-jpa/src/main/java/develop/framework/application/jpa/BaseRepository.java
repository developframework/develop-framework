package develop.framework.application.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Repository基类
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    /**
     * 是否支持该资源
     * @param resourceName 资源名称
     * @return 是否支持
     */
    boolean support(String resourceName);

    /**
     * 返回领域实体类
     * @return
     */
    Class<T> getDomainClass();
}

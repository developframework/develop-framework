package develop.framework.commons.utils;

import develop.framework.commons.exceptions.ResourceNotExistException;

import java.util.Objects;
import java.util.Optional;

/**
 * 断言
 *
 * @author qiushui on 2018-05-25.
 * @version 0.1
 */
public final class Assert {

    /**
     * 断言资源存在
     * @param resourceName 资源名称
     * @param resource 资源
     * @param <T> 资源类型
     * @return 资源
     */
    public static <T> T resourceExist(String resourceName, T resource) {
        if(Objects.isNull(resource)) {
            throw new ResourceNotExistException(resourceName);
        }
        return resource;
    }

    /**
     * 断言资源存在
     * @param resourceName 资源名称
     * @param resourceOptional 资源
     * @param <T> 资源类型
     * @return 资源
     */
    public static <T> T resourceExist(String resourceName, Optional<T> resourceOptional) {
        if(resourceOptional.isPresent()) {
            return resourceOptional.get();
        }
        throw new ResourceNotExistException(resourceName);
    }
}

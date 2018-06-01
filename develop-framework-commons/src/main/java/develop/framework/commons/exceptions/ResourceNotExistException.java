package develop.framework.commons.exceptions;

/**
 * 资源不存在异常
 * @author qiushui on 2018-05-24.
 * @version 0.1
 */
public final class ResourceNotExistException extends BusinessException {

    public ResourceNotExistException(String resourceName) {
        super("Resource \"%s\" is not exist", resourceName);
    }
}

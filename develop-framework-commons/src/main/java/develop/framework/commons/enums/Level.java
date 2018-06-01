package develop.framework.commons.enums;

/**
 * 异常级别
 * @author qiushui on 2018-05-24.
 * @version 0.1
 */
public enum Level {

    NORMAL, // 普通级，可以忽略的，通常是业务处理时失败分支主动抛出的

    DANGEROUS, // 危险级，通常是业务流程走向一个不能完成的分支所抛出

    FATAL // 致命级，通常是业务处理中没有被捕获的意外异常，是由于程序bug导致
}

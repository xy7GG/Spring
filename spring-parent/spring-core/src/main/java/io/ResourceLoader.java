package io;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 13:24
 * @Description: 加载资源
 * @Version 1.0
 */
public interface ResourceLoader {

    /**
     * 通过指定的路径返回Resource
     * 支持限定路径:"file:C:/test.dat"
     * 支持类路径:"classpath:test.dat"
     * 支持相对的文件路径:"WEB-INF/test.dat"
     * @param location
     * @return
     */
    Resource getResource(String location);

    /**
     * 返回ResourceLoader的类加载器
     * @return
     */
    ClassLoader getClassLoader();
}

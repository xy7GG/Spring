package io.support;

import io.Resource;

import java.io.IOException;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 15:53
 * @Description: 解析资源文件的策略接口
 * @Version 1.0
 */
public interface ResourcePatternResolver {
    /**
     * 在所有根目录下搜索文件的伪URL的前缀
     * 在所有的JAR包的根目录下搜索指定文件夹
      */
    String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

    /**
     * 返回指定路径下的所有的资源对象，且同一个资源只会返回一个资源对象
     * @param locationPattern
     * @return
     * @throws IOException
     */
    Resource[] getResources(String locationPattern) throws IOException;

}

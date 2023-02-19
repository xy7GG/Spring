package com.xy7.spring.beans.factory.xml;

import javax.annotation.Resource;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:28
 * @Description: 在bean定义的读取过程中传递的上下文，封装了所有相关的配置和状态
 * @Version 1.0
 */
public class ReaderContext {
    private final Resource resource;

    public ReaderContext(Resource resource) {
        this.resource = resource;
    }

    public final Resource getResource() {
        return this.resource;
    }
}

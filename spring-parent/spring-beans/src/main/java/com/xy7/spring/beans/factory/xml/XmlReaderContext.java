package com.xy7.spring.beans.factory.xml;

import com.sun.xml.internal.ws.api.ResourceLoader;

import javax.annotation.Resource;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:31
 * @Description: 对应xml的bean定义的读取器
 * @Version 1.0
 */
public class XmlReaderContext extends ReaderContext{
    public XmlReaderContext(ReaderContext resource){
        super((Resource) resource);
    }
//    private final XmlBeanDefinitionReader reader;
//
//    public XmlReaderContext(Resource resource,XmlBeanDefinitionReader reader) {
//        super(resource);
//        this.reader = reader;
//    }
//
//    public final XmlBeanDefinitionReader getReader(){
//        return this.reader;
//    }
//
//    public final BeanDefinitionReader getReader(){
//        return  this.reader.getRegistry();
//    }
//
//    public final ResourceLoader getResourceLoader(){
//        return this.reader.getResourceLoader();
//    }
//
//    public final ClassLoader getBeanClassLoader(){
//        return this.reader.getBeanClassLoader();
//    }
}

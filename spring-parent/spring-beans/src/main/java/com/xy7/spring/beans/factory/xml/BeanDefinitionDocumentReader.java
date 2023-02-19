package com.xy7.spring.beans.factory.xml;

import com.xy7.spring.beans.factory.BeanDefinitionStoreException;

import javax.swing.text.Document;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:24
 * @Description: TODO
 * @Version bean定义的文件读取器
 */
public interface BeanDefinitionDocumentReader {
    /**
     * 将读取到的document解析后，生成beanDefinition并进行注册
     * @param doc
     * @param readerContext
     * @throws BeanDefinitionStoreException
     */
    void registerBeanDefinitions(Document doc,XmlReaderContext readerContext) throws BeanDefinitionStoreException;
}

package com.xy7.spring.beans.factory.xml;

import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import javax.swing.text.Document;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:19
 * @Description: xml文件加载解析器
 * @Version 1.0
 */
public interface DocumentLoader {
    /**
     * 根据数据源来获取Document对象
     * @param inputSource
     * @param entityResolver
     * @param errorHandler
     * @param validationMode
     * @param namespaceAware
     * @return
     * @throws Exception
     */
    Document loadDocument(InputSource inputSource, EntityResolver entityResolver,
                          ErrorHandler errorHandler,int validationMode,boolean namespaceAware) throws Exception;
}

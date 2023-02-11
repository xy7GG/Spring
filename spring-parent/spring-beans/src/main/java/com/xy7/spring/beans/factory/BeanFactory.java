package com.xy7.spring.beans.factory;

import com.xy7.spring.beans.BeansException;
import com.xy7.spring.beans.NoSuchBeanDefinitionException;


public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    /**
     * 是否为单例
     * @param beanName
     * @return
     */
    boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException;

    /**
     * 是否为多例
     * @param beanName
     * @return
     */
    boolean isPrototype(String beanName) throws NoSuchBeanDefinitionException;


}

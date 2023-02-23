package com.xy7.spring.beans.factory.support;

import com.xy7.spring.beans.NoSuchBeanDefinitionException;
import com.xy7.spring.beans.factory.BeanDefinitionStoreException;
import com.xy7.spring.beans.factory.config.BeanDefinition;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/11 16:50
 * @Description: Bean属性定义的注册器
 * @Version 1.0
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefination) throws BeanDefinitionStoreException;

    void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

    BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

    int getBeanDefinitionCount();
}

package com.xy7.spring.beans.factory.support;

import com.xy7.spring.beans.NoSuchBeanDefinitionException;
import com.xy7.spring.beans.factory.BeanFactory;
import com.xy7.spring.beans.factory.config.BeanDefinition;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/23 12:16
 * @Description: 一个用来创建 单例Bean的工厂
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return true;
    }

    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    /**
     * 通过beanName检查bean工厂中是否包含bean的定义
     * @param beanName
     * @return
     */
    protected abstract boolean containsBeanDefinition(String beanName);

    /**
     * 创建一个bean的实例
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);


}

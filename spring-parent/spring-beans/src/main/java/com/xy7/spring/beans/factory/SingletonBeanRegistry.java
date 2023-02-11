package com.xy7.spring.beans.factory;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/11 11:13
 * @Description: 单例模式下的Bean注册器
 * @Version 1.0
 */
public interface SingletonBeanRegistry {
    /**
     * 根据名字 注册单例的bean
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName,Object singletonObject);

    /**
     * 根据beanName 获取单例的bean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 是否被注册
     * @param beanName
     * @return
     */
    boolean containsSingleton(String beanName);
}

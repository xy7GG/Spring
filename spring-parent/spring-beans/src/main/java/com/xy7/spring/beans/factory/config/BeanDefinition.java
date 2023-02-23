package com.xy7.spring.beans.factory.config;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/11 11:19
 * @Description: bean的属性的定义
 * @Version 1.0
 */
public interface BeanDefinition {
    /**
     * 设置bean的className
     * @param beanClassName
     */
    void setBeanClassName(String beanClassName);

    /**
     * 设置bean的作用域
     * @param scope
     */
    void setScope(String scope);

    /**
     * 设置当前bean依赖的其他bean名称
     * @param dependsOn
     */
    void setDependsOn(String... dependsOn);

    /**
     * 是否单例
     * @return
     */
    boolean isSingleton();

    /**
     * 是否为多例
     * @return
     */
    boolean isPrototype();
}

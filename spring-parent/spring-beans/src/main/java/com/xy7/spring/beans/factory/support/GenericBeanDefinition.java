package com.xy7.spring.beans.factory.support;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/23 12:02
 * @Description: Bean定义的实现类
 * @Version 1.0
 */
public class GenericBeanDefinition extends AbstractBeanDefinition{
    private volatile Object beanClass;

    private String initMethodName;

    private String destroyMethodName;

    private String scope = "";

    @Override
    public void setBeanClassName(String beanClassName) {
        this.setBeanClassName(beanClassName);
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public void setDependsOn(String... dependsOn) {
        this.setDependsOn(dependsOn);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public boolean isPrototype() {
        return false;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.setFactoryBeanName(factoryBeanName);
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public String getScope() {
        return scope;
    }
}
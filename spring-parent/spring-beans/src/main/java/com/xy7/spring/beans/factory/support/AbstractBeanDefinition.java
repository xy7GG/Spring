package com.xy7.spring.beans.factory.support;

import com.xy7.spring.beans.factory.config.BeanDefinition;
import io.Resource;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/23 11:55
 * @Description: 在bean定义之前使用抽象工厂实现一些共有的实现
 * @Version 1.0
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {
    //bean的类型
    private volatile Object beanClass;
    //bean的作用范围
    private String scope;
    //是否是抽象类
    private boolean abstractFlag;
    //是否延迟加载
    private boolean lazyInit;
    //自动注入模式
    private int autowireMode;
    //依赖检查，spring 3.0后弃用
    private int dependencyCheck;
    //表示这个bean，依赖于其它beans先实例化
    private String[] dependsOn;
    //设为false，则容器在自动装配时，将不考虑该bean（即这个bean不会作为其它bean自动装配的候选者），但是这个bean还可以自动装配其它bean
    private boolean autowireCandidate;
    //自动装配出现多个bean时，将它作为首选者
    private boolean primary;
    //允许访问非公开的构造器和方法
    private boolean nonPublicAccessAllowed;
    //是否以宽松的模式解析构造函数，默认为true
    private boolean lenientConstructorResolution;
    //指定工厂类和工厂方法
    private String factoryBeanName;
    private String factoryMethodName;
    //初始化方法
    private String initMethodName;
    //销毁方法
    private String destroyMethodName;
    //是否执行初始化方法
    private boolean enforceInitMethod;
    //是否执行销毁方法
    private boolean enforceDestroyMethod;
    //是否是用户定义的而不是应用程序本身定义的，创建AOP时为true
    private boolean synthetic;
    //定义这个bean的使用，application:用户，infrastructure：完全内部使用，与用户无关；support：某些复杂配置的一部分
    private int role;
    //bean的描述
    private String description;
    //这个bean定义的资源。
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}

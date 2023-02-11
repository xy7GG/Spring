package com.xy7.spring.beans;

public class NoSuchBeanDefinitionException extends BeansException {
    private final String beanName;

    public NoSuchBeanDefinitionException(String name, String message) {
        super("No bean name " + name + "abailable: " + message);
        this.beanName = name;
    }

    public NoSuchBeanDefinitionException(String msg) {
        super("No bean name " + msg + "abailable");
        this.beanName = msg;
    }
}

package com.xy7.spring.beans.factory.support;

import com.xy7.spring.beans.BeansException;
import com.xy7.spring.beans.NoSuchBeanDefinitionException;
import com.xy7.spring.beans.factory.BeanDefinitionStoreException;
import com.xy7.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/23 12:47
 * @Description: bean工厂的实现
 * @Version 1.0
 */
public class DefaultListableBeanFactory  extends AbstractBeanFactory implements BeanDefinitionRegistry{
    /** Map of bean definition objects, keyed by bean name. */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    //全部的BeanName
    private volatile List<String> beanDefinitionNames = new ArrayList<>(256);
    //默认的基本类型
    private static final Map<Class<?>, Object> DEFAULT_TYPE_VALUES = new HashMap<>();

    static {
        DEFAULT_TYPE_VALUES.put(boolean.class,false);
        DEFAULT_TYPE_VALUES.put(byte.class,(byte) 0);
        DEFAULT_TYPE_VALUES.put(short.class,0);
        DEFAULT_TYPE_VALUES.put(long.class,0L);
        DEFAULT_TYPE_VALUES.put(float.class,0F);
        DEFAULT_TYPE_VALUES.put(double.class,0D);
        DEFAULT_TYPE_VALUES.put(char.class,'\0');
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        synchronized (this.beanDefinitionMap) {
            beanDefinitionMap.put(beanName,beanDefinition);
            List<String> updatedDefinitions = new ArrayList<>(this.beanDefinitionNames.size() + 1);
            updatedDefinitions.addAll(this.beanDefinitionNames);
            updatedDefinitions.add(beanName);
            this.beanDefinitionNames = updatedDefinitions;
        }

    }

    @Override
    public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
        BeanDefinition bd = this.beanDefinitionMap.remove(beanName);
        synchronized (this.beanDefinitionMap) {
            List<String> updatedDefinitions = new ArrayList<>(this.beanDefinitionNames);
            updatedDefinitions.remove(beanName);
            this.beanDefinitionNames = updatedDefinitions;
        }
    }

    @Override
    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }


    @Override
    protected boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
        return beanDefinitionMap.get(beanName);
    }

    /**
     * 从xml中读取了bean的定义<bean id="xx" class="sss" init-method="init" /> -> BeanDefinition
     * 使用一个类的时候 实例化 new BeanDefinition 转换为具体的实例
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanDefinition;

        Object beanClass = genericBeanDefinition.getBeanClass();
        Object singleton = this.getSingleton(beanName);
        if (singleton != null){
            return singleton;
        }
        Class<?> clazz = (Class<?>) beanClass;
        if (clazz.isInterface()){
            throw new BeansException("bean不能为接口");
        }
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            Object[] argsWithDefaultValues = new Object[args.length];
            for (int i = 0 ; i < args.length; i++) {
                if (args[i] == null) {
                    Class<?> parameterType = parameterTypes[i];
                    argsWithDefaultValues[i] = (parameterType.isPrimitive() ? DEFAULT_TYPE_VALUES.get(parameterType) : null);
                }
                else {
                    argsWithDefaultValues[i] = args[i];
                }
            }
            try {
                return declaredConstructor.newInstance(argsWithDefaultValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在获取bean的时候对其进行实例化
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = getSingleton(beanName);
        if (singleton == null){
            //若bean定义里存在但未对其进行实例化
            if (beanDefinitionMap.containsKey(beanName)){
                if (isSingleton(beanName)){
                    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
                    Object bean = createBean(beanName, beanDefinition,new Object[]{});
                    registerSingleton(beanName,bean);
                    return bean;
                }
            }
        }
        return singleton;
    }
}
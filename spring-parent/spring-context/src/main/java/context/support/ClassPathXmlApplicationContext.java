package context.support;

import com.xy7.spring.beans.BeansException;
import com.xy7.spring.beans.NoSuchBeanDefinitionException;
import context.ApplicationContext;
import io.Resource;

import java.io.IOException;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:48
 * @Description: 读取classpath下的xml文件，注册bean到Spring容器中，
 * 根据beanName获取容器中的bean，ApplicationContext的其中一个实现
 * @Version 1.0
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    public ClassPathXmlApplicationContext(){

    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isPrototype(String beanName) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getApplicationName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public Resource[] getResources(String locationPattern) throws IOException {
        return new Resource[0];
    }
}

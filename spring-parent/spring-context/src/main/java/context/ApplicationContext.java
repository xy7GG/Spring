package context;

import com.xy7.spring.beans.factory.BeanFactory;
import io.support.ResourcePatternResolver;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 16:10
 * @Description:
 * @Version 1.0
 */
public interface ApplicationContext extends BeanFactory, ResourcePatternResolver {

    String getId();

    String getApplicationName();

    String getDisplayName();

}

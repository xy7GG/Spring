package io.InputStreamSource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 13:31
 * @Description: TODO
 * @Version 1.0
 */
public interface InputStreamSource {
    /**
     * 定位并打开资源，返回用于从资源读取的输入流，若资源不存在则抛出该异常
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}

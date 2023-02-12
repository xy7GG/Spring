package io;

import io.InputStreamSource.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 13:27
 * @Description: 定义Bean的xml文件资源
 * @Version 1.0
 */
public interface Resource extends InputStreamSource {
    /**
     * 资源是否存在
     * @return
     */
    boolean exists();

    /**
     * 资源是否可读
     * @return
     */
    default boolean isReadable(){
        return exists();
    }

    /**
     * true，只能读取一次InputStream，然后关闭
     * false,非InputStream流
     * @return
     */
    default boolean isOpen(){
        return false;
    }

    /**
     * 返回资源的URL
     * @return
     * @throws IOException
     */
    URL getURL() throws IOException;

    /**
     * 返回资源的URL
     * @return
     * @throws IOException
     */
    URI getURI() throws IOException;

    /**
     * 得到File对象
     * @return
     * @throws IOException
     */
    File getFile() throws IOException;

    /**
     * 可读字节的Channel,
     * 一个通道上只能进行一个读取操作，多线程状态下对其他发起阻塞的线程进行阻塞
     * @return
     * @throws IOException
     */
    default ReadableByteChannel readableChannel() throws IOException{
        return Channels.newChannel(getInputStream());
    }

    /**
     * 资源的内容长度
     * @return
     * @throws IOException
     */
    long contentLength() throws IOException;

    /**
     * 最后修改时间
     * @return
     * @throws IOException
     */
    long lastModified() throws IOException;

    /**
     * 根据相对路径创建对应的资源
     * @param relativePath
     * @return
     * @throws IOException
     */
    Resource createRelative(String relativePath) throws IOException;

    /**
     * 资源文件名
     * @return
     */
    String getFilename();

    /**
     * 返回此资源的描述
     * @return
     */
    String getDescription();

}

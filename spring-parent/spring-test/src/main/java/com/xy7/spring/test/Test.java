package com.xy7.spring.test;

import context.support.ClassPathXmlApplicationContext;

/**
 * @Author yuanqi.xing
 * @Date 2023/2/12 17:51
 * @Description: TODO
 * @Version 1.0
 */
public class Test {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    Object goodsService = ctx.getBean("goodsService");
    -
}

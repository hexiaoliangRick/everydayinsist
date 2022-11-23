package com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy;


import com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.jdk.ProxyFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 14:46
 * @description:
 */
@Slf4j
public class ProxyFactoryTest {


    @Test
    public void test_JDK_DynamicProxy() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(target);
        IUserDao proxy = (IUserDao) (proxyFactory.getInstance());
        System.out.println(proxy.getClass());
        proxy.save();
        proxy.toString();
        proxy.getClass();
        // 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IUserDao.class});
        try {
            FileOutputStream os = new FileOutputStream("Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            log.error("{}", e);
        }
    }


    @Test
    public void test_CGLib_DynamicProxy() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.cglib.ProxyFactory proxyFactory = new com.cpu.onlyplay.everydayinsist.javadesignpattern.proxy.cglib.ProxyFactory(target);
        IUserDao proxy = (IUserDao) (proxyFactory.getInstance());
//        System.out.println(proxy.getClass());
        proxy.save();
    }


}
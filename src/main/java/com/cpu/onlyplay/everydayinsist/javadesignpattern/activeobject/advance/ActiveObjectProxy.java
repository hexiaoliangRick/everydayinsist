package com.cpu.onlyplay.everydayinsist.javadesignpattern.activeobject.advance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author: cpuRick
 * @createTime: 2022/08/17 9:43
 * @description: 可复用的ActiveObject Proxy 动态代理模式
 * <p>
 * https://www.infoq.cn/article/java-multithreaded-programming-mode-active-object-part2
 */
public abstract class ActiveObjectProxy {


    private static class DispatchInvocationHandler implements InvocationHandler {

        private final Object delegate;

        private final ExecutorService scheduler;


        /**
         * @param delegate  被代理对象
         * @param scheduler 调度器
         */
        private DispatchInvocationHandler(Object delegate, ExecutorService scheduler) {
            this.delegate = delegate;
            this.scheduler = scheduler;
        }


        /**
         * 构建被代理对象的名称
         *
         * @param method
         * @param arg
         * @return
         */
        private String makeDelegateMethodName(final Method method,
                                              final Object[] arg) {
            String name = method.getName();
            name = "do" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

            return name;
        }


        /**
         * 代理对象调用
         *
         * @param proxy  the proxy instance that the method was invoked on
         * @param method the {@code Method} instance corresponding to
         *               the interface method invoked on the proxy instance.  The declaring
         *               class of the {@code Method} object will be the interface that
         *               the method was declared in, which may be a superinterface of the
         *               proxy interface that the proxy class inherits the method through.
         * @param args   an array of objects containing the values of the
         *               arguments passed in the method invocation on the proxy instance,
         *               or {@code null} if interface method takes no arguments.
         *               Arguments of primitive types are wrapped in instances of the
         *               appropriate primitive wrapper class, such as
         *               {@code java.lang.Integer} or {@code java.lang.Boolean}.
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            final Object delegate = this.delegate;
            Method delegateMethod = null;
            Object returnValue = null;
            if (Future.class.isAssignableFrom(method.getReturnType())) {
                delegateMethod = delegate.getClass().getMethod(makeDelegateMethodName(method, args), method.getParameterTypes());
                final ExecutorService scheduler = this.scheduler;
                final Method finalDelegateMethod = delegateMethod;
                Callable<Object> callable = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        Object rv = null;
                        rv = finalDelegateMethod.invoke(delegate, args);
                        return rv;
                    }
                };
                //提交任务
                Future<Object> future = scheduler.submit(callable);
                returnValue = future;
            } else {
                delegateMethod = delegate.getClass().getMethod(method.getName(), method.getParameterTypes());
                returnValue = delegateMethod.invoke(delegate, args);
            }
            return returnValue;

        }
    }


    public static <T> T newInstance(Class<T> interf, Object servant, ExecutorService scheduler) {
        T f = (T) Proxy.newProxyInstance(interf.getClassLoader(), new Class[]{interf}, new DispatchInvocationHandler(servant, scheduler));
        return f;

    }

}

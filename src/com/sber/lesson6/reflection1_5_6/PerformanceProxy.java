package com.sber.lesson6.reflection1_5_6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.LocalTime;

public class PerformanceProxy implements InvocationHandler {

    private Object delegate;

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T proxyFactory(Object delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceProxy(delegate));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            LocalTime start = LocalTime.now();
            Object value = method.invoke(delegate, args);
            LocalTime stop = LocalTime.now();
            Duration duration = Duration.between(start, stop);
            System.out.printf("Время работы метода: %d (в наносек)%n",
                    duration.toNanos(), duration.toMillis());
            return value;
        }
        return method.invoke(delegate, args);
    }
}

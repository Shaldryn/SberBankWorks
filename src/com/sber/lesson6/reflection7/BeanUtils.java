package com.sber.lesson6.reflection7;

import com.sber.lesson6.reflection2_3_4.MyClassChild;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {

        List<Method> fromGetters = getListGetters(from);
        List<Method> toSetters = getListSetters(to);

        if (toSetters.isEmpty() || fromGetters.isEmpty()) {
            throw new IllegalArgumentException("В переданных объектах отсутствуют геттеры или сеттеры");
        }

        for (Method setter : toSetters) {
            Class paramSetter = setter.getParameterTypes()[0];
            String nameSetter = setter.getName().substring(3);
            for (Method getter : fromGetters) {
                Class returnGetter = getter.getReturnType();
                String nameGetter = getter.getName().substring(3);
                if (paramSetter.isAssignableFrom(returnGetter) && nameGetter.equals(nameSetter)) {
                    setter.invoke(to, getter.invoke(from));
                }
            }
        }

    }

    private static List<Method> getListGetters(Object o) {

        List<Method> list = new ArrayList<>();
        Method[] methods = o.getClass().getMethods();
        for (Method method :
                methods) {
            if (isGetter(method)) {
                list.add(method);
            }
        }
        return list;
    }

    private static List<Method> getListSetters(Object o) {

        List<Method> list = new ArrayList<>();
        Method[] methods = o.getClass().getMethods();
        for (Method method :
                methods) {
            if (isSetter(method)) {
                list.add(method);
            }
        }
        return list;
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}

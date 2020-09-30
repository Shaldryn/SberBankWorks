package com.sber.lesson6.reflection7;

import java.lang.reflect.InvocationTargetException;

public class DemoTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MyClass1 myClass1 = new MyClass1("class1", 10, false, 25);
        MyClass2 myClass2 = new MyClass2("Class2", 20, 255);

        System.out.println(myClass1);
        System.out.println(myClass2);
        BeanUtils.assign(myClass1, myClass2);
        System.out.println(myClass1);
        System.out.println(myClass2);

    }
}

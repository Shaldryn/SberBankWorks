package com.sber.lesson6.reflection2_3_4;

import java.lang.reflect.Method;

public class MyClassChild extends MyClass {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGetter(Method method) {
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

    public static void main(String[] args) throws Exception {

        /*
        Задание 2: Вывести на консоль все методы класса, включая все родительские методы
        (включая приватные)
         */
        Class myObjectClass = MyClassChild.class;

        Method[] publicMethods = myObjectClass.getMethods();

        System.out.println("Public methods: ");
        for (Method method :
                publicMethods) {
            System.out.println(method);
        }

        Method[] privateMethods = myObjectClass.getDeclaredMethods();
        Method[] privateMethodsSuperClass = myObjectClass.getSuperclass().getDeclaredMethods();

        System.out.println("Private methods: ");
        for (Method method :
                privateMethods) {
            System.out.println(method);
        }
        for (Method method :
                privateMethodsSuperClass) {
            System.out.println(method);
        }

        /*
        Задача 3: Вывести все геттеры класса
         */
        System.out.println("Getters methods: ");
        for (Method method :
                publicMethods) {
            if (isGetter(method)) {
                System.out.println("getter: " + method);
            }
        }

        /*
        Задача 4: Проверить что все String константы имеют значение = их имени
         */
        System.out.println("Check fields: ");
//        Field[] fields = myObjectClass.getFields();
//                for (Field field :
//                fields) {
//            System.out.println("field: " + field.isEnumConstant() + " " + field.getName());
//        }

        String[] arrayStrings = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        boolean result = true;
        for (String nameString :
                arrayStrings) {
          if (myObjectClass.getDeclaredField(nameString).get(null) != nameString) {
              result = false;
          }
        }

        System.out.println(result + ". All fields match!");

    }
}

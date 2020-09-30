package com.sber.lesson6.reflection7;

public class MyClass1 {

    private String name;
    private int age;
    private boolean lock;
    private int weight;

    public MyClass1(String name, int age, boolean lock, int weight) {
        this.name = name;
        this.age = age;
        this.lock = lock;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MyClass1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lock=" + lock +
                ", weight=" + weight +
                '}';
    }
}

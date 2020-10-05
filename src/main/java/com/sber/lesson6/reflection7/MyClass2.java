package com.sber.lesson6.reflection7;

public class MyClass2 {

    private String name;
    private int age;
    private int colorRGB;

    public MyClass2(String name, int age, int colorRGB) {
        this.name = name;
        this.age = age;
        this.colorRGB = colorRGB;
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

    public int getColorRGB() {
        return colorRGB;
    }

    public void setColorRGB(int colorRGB) {
        this.colorRGB = colorRGB;
    }

    @Override
    public String toString() {
        return "MyClass2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colorRGB=" + colorRGB +
                '}';
    }
}

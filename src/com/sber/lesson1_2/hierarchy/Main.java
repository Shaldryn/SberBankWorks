package com.sber.lesson1_2.hierarchy;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Rect(), new Square(), new Triangle()};

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }
}

package com.sber.lesson2.task7;

import java.util.ArrayList;
import java.util.List;

public class Auto {

    private static final String [] types = {"sedan", "hatchback", "liftback", "crossover", "universal"};
    private static final String [] models = {"Lada", "BMW", "Mercedes", "Pego", "Ford", "Toyota", "Nissan"};

    private String type;
    private String model;

    public Auto(String type, String model) {
        this.type = type;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public static List<Auto> init(int count) {
        List<Auto> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String model = models[(int)(Math.random()* models.length)];
            String type = types[(int)(Math.random()* types.length)];
            list.add(new Auto(type, model));
        }
        return list;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

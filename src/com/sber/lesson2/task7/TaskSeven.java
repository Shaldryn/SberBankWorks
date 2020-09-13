package com.sber.lesson2.task7;

import java.util.*;

public class TaskSeven {

    public static void main(String[] args) {

        List<Auto> allAuto = Auto.init(20);
        Map<String, List<Auto>> groupAuto = new HashMap<>();

        System.out.println("------------------------------");
        System.out.println("Первоначальный список:");
        System.out.println("------------------------------");
        allAuto.forEach(System.out::println);

        for (Auto a : allAuto) {
            String type = a.getType();
            if (groupAuto.containsKey(type)) {
                groupAuto.get(type).add(a);
            } else {
                groupAuto.put(type, new ArrayList<>(List.of(a)));
            }
        }

        groupAuto.forEach((k, v) -> {
            System.out.println("------------------------------");
            System.out.println("Сгруппированные по типу: " + k);
            System.out.println("------------------------------");
            v.forEach(System.out::println);
        });

    }
}

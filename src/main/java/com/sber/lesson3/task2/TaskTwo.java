package com.sber.lesson3.task2;

import com.sber.lesson3.SourceText;

import java.util.stream.Stream;

public class TaskTwo {

    public static void sortAlphabetically(String text) {
        Stream.of(text.split("[^a-zA-Zа-яА-Яё-]+"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);
    }

    public static void sortLenght(String text) {
        Stream.of(text.split("[^a-zA-Zа-яА-Яё-]+"))
                .map(String::toLowerCase)
                .sorted((o1, o2) -> {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    }
                    return o1.compareTo(o2);
                })
                .forEach(System.out::println);
    }


    public static void main(String[] args) {

        TaskTwo.sortAlphabetically(SourceText.text);
        TaskTwo.sortLenght(SourceText.text);

    }
}

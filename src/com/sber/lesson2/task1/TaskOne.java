package com.sber.lesson2.task1;

import com.sber.lesson2.SourceText;

import java.util.stream.Stream;

public class TaskOne {

    public static long numberDifferentWords(String text) {
        return Stream.of(text.split("[^a-zA-Zа-яА-Яё-]+"))
                .map(String::toLowerCase)
                .distinct()
                .count();
    }


    public static void main(String[] args) {

        System.out.println(TaskOne.numberDifferentWords(SourceText.text));

    }
}

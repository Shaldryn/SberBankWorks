package com.sber.lesson3.task3;

import com.sber.lesson3.SourceText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class TaskThree {

    public static void numberWords(String text) {

        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        Stream.of(text.split("[^a-zA-Zа-яА-Яё-]+"))
                .map(String::toLowerCase)
                .forEach(s -> arrayList.add(s));

        for (String string :
                arrayList) {
            hashMap.put(string, Collections.frequency(arrayList, string));
        }

        hashMap.forEach((s, integer) -> System.out.println(s + " = " + integer));

    }

    public static void main(String[] args) {

        TaskThree.numberWords(SourceText.text);

    }
}

package com.sber.lesson3.task4;

import com.sber.lesson3.SourceText;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFour {

    public static void main(String[] args) {

        List<String> listStrings = new ArrayList<>();

        listStrings = Stream.of(SourceText.text.split("\\n")).collect(Collectors.toList());

        for (int i = listStrings.size() - 1; i >= 0; i--) {
            System.out.println(listStrings.get(i));
        }



    }

}

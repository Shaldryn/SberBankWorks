package com.sber.lesson2.task5;

import com.sber.lesson2.SourceText;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFive {

    public static void main(String[] args) {

        MyList<String> myListIterator = new MyList(Stream.of(SourceText.text.split("\\n")).collect(Collectors.toList()));

        for (String s :
                myListIterator) {
            System.out.println(s);
        }
    }
}

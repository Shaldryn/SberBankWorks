package com.sber.lesson2.task6;

import com.sber.lesson2.SourceText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskSix {

    public static void printStrings(List<String> list) {

        System.out.println("Введите номера строк через пробел");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            for (String s : str.split("\\s")) {
                int n = Integer.parseInt(s);
                try {
                    System.out.println(list.get(n - 1));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Строкa с номером " + n + " отсутствует в тексте");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        List<String> listStrings = new ArrayList<>(Stream.of(SourceText.text.split("\\n")).collect(Collectors.toList()));

        TaskSix.printStrings(listStrings);

    }

}

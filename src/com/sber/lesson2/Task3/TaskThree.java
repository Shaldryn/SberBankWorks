package com.sber.lesson2.Task3;

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

        String text = "Практический опыт показывает, что реализация намеченного плана развития обеспечивает актуальность экономической \n" +
                "целесообразности принимаемых решений. Значимость этих проблем настолько очевидна, что постоянное информационно-техническое обеспечение нашей деятельности в \n" +
                "значительной степени обуславливает создание системы обучения кадров, соответствующей насущным потребностям! С другой стороны дальнейшее развитие различных форм \n" +
                "деятельности напрямую зависит от существующих финансовых и административных условий? Равным образом социально-экономическое развитие обеспечивает актуальность \n" +
                "новых предложений? Равным образом рамки и место обучения кадров требует от нас системного анализа всесторонне сбалансированных нововведений. Значимость этих \n" +
                "проблем настолько очевидна, что дальнейшее развитие различных форм деятельности обеспечивает актуальность дальнейших направлений развития проекта. Соображения \n" +
                "высшего порядка, а также повышение уровня гражданского сознания напрямую зависит от модели развития. Практический опыт показывает, что сложившаяся структура \n" +
                "организации напрямую зависит от существующих финансовых и административных условий. Равным образом постоянное информационно-техническое обеспечение нашей деятельности \n" +
                "обеспечивает широкому кругу специалистов участие в формировании дальнейших направлений развития проекта! Соображения высшего порядка, а также курс на социально-ориентированный \n" +
                "национальный проект представляет собой интересный эксперимент проверки дальнейших направлений развития проекта. Повседневная практика показывает, что повышение уровня \n" +
                "гражданского сознания играет важную роль в формировании дальнейших направлений развития проекта. Соображения высшего порядка, а также сложившаяся структура организации \n" +
                "создаёт предпосылки качественно новых шагов для существующих финансовых и административных условий. С другой стороны сложившаяся структура организации...";


        TaskThree.numberWords(text);

    }
}

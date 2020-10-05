package com.sber.lesson4.generics2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<T> source, Object o) {

       return source.indexOf(o);

//        if (o == null) {
//            for (int i = 0; i < source.size(); i++) {
//                if (source.get(i) == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = 0; i < source.size(); i++) {
//                if (o.equals(source.get(i))) {
//                    return i;
//                }
//            }
//        }
//        return -1;
    }

    public static <T> List<T> limit(List<T> source, int size) {

        return source.stream().limit(size).collect(Collectors.toList());

    }

    public static <T> void add(List<T> source, Object o) {

        source.add((T) o);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        for (T e : c2)
            if (c1.contains(e))
                return true;
        return false;
    }

    public static <T> List<T> range(List<T> list, Object min, Object max) {
        List<T> newList = new ArrayList<>(list);
        return newList.subList(list.indexOf(min), list.indexOf(max));
    }

    public static <T> List<T> range(List<T> list, Object min, Object max, Comparator<? super T> comparator) {
        List<T> newList = new ArrayList<>(list);
        newList.sort(comparator);

        return newList.subList(newList.indexOf(min), newList.lastIndexOf(max)+1);
    }
}
